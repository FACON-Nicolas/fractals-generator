package fr.univartois.butinfo.fractals.figure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public abstract class AbstractFractalesSVG {
	private int width;
	private int height;
	private IFigure figure;
	private int iterations;
	
	public AbstractFractalesSVG(int width, int height,IFigure figure,int iterations) {
		this.width = width;
		this.height = height;
		this.figure=figure;
		this.iterations = iterations;
	}
	
	protected Writer ouvrirFichier() {
		try {
			PrintWriter  obj = new PrintWriter("file.svg");
			return obj;
		} catch (FileNotFoundException e) {
			System.err.println("erreur d'ouverture");
			e.printStackTrace();
		}
		return null;
		
	}
	
	protected Writer ecrireEnTete(Writer file) {
		try {
			file.write("<svg version='1.1' baseProfile='full width='"+width+"' height='"+height+"' xmlns='http://www.w3.org/2000/svg'>");
			return file;
		} catch (IOException e) {
			System.err.println("problème dans l'écriture de l'en-tête");
			e.printStackTrace();
		}
		return null;
	};
	protected Writer creerFormesBase(Writer file, IFigure figure) throws IOException {
		file.write(figure.getSVG());
		return file;
	};
	
	public abstract Writer formerFractale(Writer file, IFigure figure,int iterations);
	
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
	};
	
	
	public final void creerFractalesSvg() {
		Writer writer = ouvrirFichier();
		writer = ecrireEnTete(writer);
		try {
			writer = creerFormesBase(writer,figure);
		} catch (IOException e) {
			System.err.println("problème dans la création de la forme de base");
		}
		writer = formerFractale(writer,figure,iterations);
		writer =fermerSvg(writer);
		fermerFichier(writer);
		}
	}
