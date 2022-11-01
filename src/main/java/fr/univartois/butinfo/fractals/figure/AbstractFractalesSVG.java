package fr.univartois.butinfo.fractals.figure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Cette classe est la classe abstraite du patron de conception méthode. Elle permet de créer une 
 * fractale à base de figures géométriques dans un fichier.
 *
 * @author Elsa
 *
 * @version 0.1.0
 */
public abstract class AbstractFractalesSVG {
	/**
	 * La largeur de l'image de la fractale.
	 */
	private int width;
	/**
	 * La hauteur de l'image de la fractale.
	 */
	private int height;
	/**
	 * Une figure (carré, rond , triangle ...).
	 */
	private IFigure figure;
	/**
	 * L'attribut iterations définit le nombre d'itérations de la fractale à créer.
	 */
	private int iterations;
	
	/**
	 * Crée une nouvelle instance de AbstractFractalesSVG.
	 * @param width La largeur de l'image de la fractale.
	 * @param height La hauteur de l'image de la fractale.
	 * @param figure La figure géométrique qu'utilise la fractale
	 * @param iterations Le nombre d'itérations de la fractale.
	 */
	public AbstractFractalesSVG(int width, int height,IFigure figure,int iterations) {
		this.width = width;
		this.height = height;
		this.figure=figure;
		this.iterations = iterations;
	}
	
	/**
	 * Cette méthode permet d'ouvrir ou de créer et d'ouvrir le fichier dans lequel sera généré la fractale géométrique.
	 * @return obj Le nouveau fichier svg.
	 */
	protected Writer ouvrirFichier(String outputFile) {
		try {
			PrintWriter  obj = new PrintWriter(outputFile);
			return obj;
		} catch (FileNotFoundException e) {
			System.err.println("erreur d'ouverture");
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Méthode permettant d'écrire l'en-tête d'un fichier SVG.
	 * @param file le fichier SVG dans lequel sera généré la fractale.
	 * @return le fichier svg modifié.
	 */
	protected Writer ecrireEnTete(Writer file) {
		try {
			file.write("<svg version=\"1.1\" width=\""+width+"\" height=\""+height+"\" xmlns=\"http://www.w3.org/2000/svg\">");
			return file;
		} catch (IOException e) {
			System.err.println("problème dans l'écriture de l'en-tête");
			e.printStackTrace();
		}
		return null;
	};
	/**
	 * Cette méthode permet de définir la forme de base générée dans la fractale géométrique.
	 * @param file Le fichier SVG dans lequel sera généré la fractale.
	 * @param figure La figure géométrique qu'utilise la fractale.
	 * @return file , le fichier passé en paramètre avec la figure en svg écrite.
	 * @throws IOException une exception.
	 */
    protected Writer creerFormesBase(Writer file, IFigure figure) throws IOException {
		file.write(figure.getSVG());
		return file;
	}
	
	/**
	 * La méthode permettant de former la fractale et de l'écrire dans le ficheir SVG.
	 * @param file Le fichier SVG dans lequel sera généré la fractale.
	 * @param figure La figure géométrique qu'utilise la fractale.
	 * @param iterations Le nombre d'itérations de la fractale.
	 * @return file , le fichier passé en paramètre avec la fractale générée dedans.
	 */
	public abstract Writer formerFractale(Writer file, IFigure figure,int iterations) throws IOException;
	
	/**
	 * La méthode permettant de fermer le fichier SVG.
	 * @param file Le fichier SVG dans lequel est généré la fractale.
	 * @return file Le fichier passé en paramètre avec la balise fermant le fichier svg ajouté dedans.
	 */
	protected Writer fermerSvg(Writer file) {
		try {
			file.write("</svg>");
			return file;
		} catch (IOException e) {
			System.err.println("problème dans la fermeture du fichier");
			e.printStackTrace();
		}
		return null;
	};
	/**
	 * Méthode permettant de femrer le fichier SVG
	 * @param file Le fichier SVG dans lequel est généré la fractale.
	 */
	protected void fermerFichier(Writer file) {
		try {
			file.flush();
		} catch (IOException e) {
			System.err.println("erreur dans le flush");
			e.printStackTrace();
		}
		try {
			file.close();
		} catch (IOException e) {
			System.err.println("erreur dans la fermeture du fichier");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Méthode permettant de générer l'intégralité du fichier SVG du début à la fin. 
	 */
	public final void creerFractalesSvg(String outputFile) {
		Writer writer = ouvrirFichier(outputFile);
		writer = ecrireEnTete(writer);
		try {
			writer = creerFormesBase(writer,figure);
		} catch (IOException e) {
			System.err.println("problème dans la création de la forme de base");
		}
		try {
			writer = formerFractale(writer,figure,0);
		} catch (IOException e) {
			System.err.println("problème dans la formation du fractale");
		}
		writer =fermerSvg(writer);
		fermerFichier(writer);
	}
	
	
    /**
     * Donne l'attribut iterations de cette instance de AbstractFractalesSVG.
     *
     * @return L'attribut iterations de cette instance de AbstractFractalesSVG.
     */
    public int getIterations() {
        return iterations;
    }
}
