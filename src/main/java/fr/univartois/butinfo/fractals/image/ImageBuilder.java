/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import fr.univartois.butinfo.couleurs.IStrategieCouleurs;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.PlanComplex;
import fr.univartois.butinfo.fractals.complex.PlanComplexZoomDecorator;
import fr.univartois.butinfo.fractals.complex.Point;
import fr.univartois.butinfo.fractals.figure.TapisSierpinski;
import fr.univartois.butinfo.fractals.figure.TapisSierpinskiDiagonale;
import fr.univartois.butinfo.fractals.figure.TriangleSierpinski;
import fr.univartois.butinfo.fractals.suite.simple.IStrategieSuite;
import fr.univartois.butinfo.fractals.suite.simple.SuiteGeneraliseJulia;
import fr.univartois.butinfo.fractals.suite.simple.SuiteGeneraliseMandelbrot;
import fr.univartois.butinfo.fractals.suite.simple.SuiteIterator;
import fr.univartois.butinfo.fractals.suite.simple.SuiteJulia;
import fr.univartois.butinfo.fractals.suite.simple.SuiteMandelbrot;

/**
 * Le type GenerateurImageBuilder
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class ImageBuilder {
    
    /**
     * La hauteur de l'image.
     */
    private int height;
    
    /**
     * La largeur de l'image.
     */
    private int width;
    
    /**
     * Le point central de l'image.
     */
    private IPoint pointCentral;
    
    /**
     * Une palette de couleur.
     */
    private IStrategieCouleurs palette;
    
    /**
     * Le chemin vers l'image.
     */
    private String path;

    /**
     * Le nom de la suite utilisée.
     */
    private String nom;
    
    /**
     * L'échelle de l'image.
     */
    private double echelle;
    
    /**
     * On ne peut pas créer de constructeur dans un builder.
     */
    private ImageBuilder() {
        
    }
    
    /**
     * @return Une nouvelle instance de ImageBuilder.
     */
    public static ImageBuilder newInstance() {
        return new ImageBuilder();
    }
    
    /**
     * Cette méthode donne une échelle à l'image.
     * @param echelle L'échelle de l'image
     * @return Image avec une échelle.
     */
    public ImageBuilder withEchelle(double echelle) {
        this.echelle = echelle;
        return this;
    }
    
    /**
     * Cette méthode donne une largeur à l'image.
     * @param width Une largeur.
     * @return la largeur de l'image.
     */
    public ImageBuilder withWidth(int width) {
        this.width = width;
        return this;
    }
    
    /**
     * Cette méthode donne une hauteur à l'image.
     * @param height Une hauteur.
     * @return la hauteur de l'image.
     */
    public ImageBuilder withHeight(int height) {
        this.height = height;
        return this;
    }
    
    /**
     * Cette méthode définit le point central de l'image.
     * @param central un point.
     * @return le point central de l'image.
     */
    public ImageBuilder withPointCentral(IPoint central) {
        this.pointCentral = central;
        return this;
    }
    
    /**
     * Cette méthode définit la palette de couleur utilisée par l'image.
     * @param palette Une palette.
     * @return une palette.
     */
    public ImageBuilder withPalette(IStrategieCouleurs palette) {
        this.palette = palette;
        return this;
    }
    
    /**
     * Méthode qui définit le chemin par lequel on retrouvera l'image de la fractale.
     * @param path Un chemin.
     * @return Le chemin vers le fichier qui contiendra l'image.
     */
    public ImageBuilder withPath(String path) {
        this.path = path;
        return this;
    }
    
    /**
     * @param nom Le nom d'une suite.
     * @return Le nom de la suite utilisée.
     */
    public ImageBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }
    
    /**
     * Donne l'attribut width de cette instance de ImageBuilder.
     *
     * @return L'attribut width de cette instance de ImageBuilder.
     */
    public int getWidth() {
        return width;
    }
    
    
    /**
     * Donne l'attribut height de cette instance de ImageBuilder.
     *
     * @return L'attribut height de cette instance de ImageBuilder.
     */
    public int getHeight() {
        return height;
    }
    
    
    /**
     * Donne l'attribut pointCentral de cette instance de ImageBuilder.
     *
     * @return L'attribut pointCentral de cette instance de ImageBuilder.
     */
    public IPoint getPointCentral() {
        return pointCentral;
    }
    
    
    /**
     * Donne l'attribut palette de cette instance de ImageBuilder.
     *
     * @return L'attribut palette de cette instance de ImageBuilder.
     */
    public IStrategieCouleurs getPalette() {
        return palette;
    }
    
    
    /**
     * Donne l'attribut echelle de cette instance de ImageBuilder.
     *
     * @return L'attribut echelle de cette instance de ImageBuilder.
     */
    public double getEchelle() {
        return echelle;
    }
    
    
    /**
     * Donne l'attribut nom de cette instance de ImageBuilder.
     *
     * @return L'attribut nom de cette instance de ImageBuilder.
     */
    public String getNom() {
        return nom;
    }
    
    
    /**
     * Donne l'attribut path de cette instance de ImageBuilder.
     *
     * @return L'attribut path de cette instance de ImageBuilder.
     */
    public String getPath() {
        return path;
    }
   
    /**
     * Méthode qui permet de générer l'image.
     * @throws IOException une exception
     */
    public void generation() throws IOException {
        Complex c = new Complex(-0.4,  0.6);
        int nbIt = 0;
        int maxIt = 0;
        PlanComplex plan = new PlanComplex(width, height);
        IStrategieSuite s = null;
        SuiteIterator it = null;
        PlanComplexZoomDecorator planZoom = new PlanComplexZoomDecorator(echelle, plan, width, height);
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                IComplex complex = planZoom.asComplex(j, i);
                complex = complex.add(((Point) pointCentral).fromPointToComplex());
                if ("julia".equalsIgnoreCase(nom)) {
                    s = new SuiteJulia(complex, c, 124);
                    it = (SuiteIterator) ((SuiteJulia)(s)).iterator();
                    maxIt = ((SuiteJulia)(s)).getMaxIteration();
                } else if ("mandelbrot".equalsIgnoreCase(nom)) {
                    c = new Complex(-0.743643887037151, 0.13182590420533);                    
                    s = new SuiteMandelbrot(complex, 124);
                    it = (SuiteIterator) ((SuiteMandelbrot)(s)).iterator();
                    maxIt = ((SuiteMandelbrot)(s)).getMaxIteration();
                } else if ("juliaGeneralise".equalsIgnoreCase(nom)) {
                    c = new Complex(-0.6078,0.4380);                    
                    s = new SuiteGeneraliseJulia(complex, c, 124, (z, e) -> z.multiply(z).add(e));
                    it = (SuiteIterator) ((SuiteGeneraliseJulia)(s)).iterator();
                    maxIt = ((SuiteGeneraliseJulia)(s)).getMaxIteration();
                } else if ("mandelbrotGeneralise".equalsIgnoreCase(nom)) {    
                    c = new Complex(-0.743643887037151, 0.13182590420533);                    
                    s = new SuiteGeneraliseMandelbrot(complex, 124, (z, e) -> (z.multiply(z).add(z)).divide(z.multiply(z).multiply(z).add(e)));
                    it = (SuiteIterator) ((SuiteGeneraliseMandelbrot)(s)).iterator();
                    maxIt = ((SuiteGeneraliseMandelbrot)(s)).getMaxIteration();
                } 
                
                while (it.hasNext()) it.next();
                image.setColor(j, i, palette.palette(maxIt, it.getNbInteration()));
                
                if ("triangle".equalsIgnoreCase(nom)) {
                    TriangleSierpinski.main(null);
                } else if ("tapis".equalsIgnoreCase(nom)) {
                    TapisSierpinski.main(null);
                } else if ("tapisDiagonale".equalsIgnoreCase(nom)) {
                    TapisSierpinskiDiagonale.main(null);
                }
            }
        }
        image.saveAs(path);
    }
 
}

