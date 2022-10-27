/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.function.BinaryOperator;

import fr.univartois.butinfo.couleurs.IStrategieCouleurs;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.PlanComplex;
import fr.univartois.butinfo.fractals.complex.PlanComplexZoomDecorator;
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
    
    private int height;
    
    private int width;
    
    private IPoint pointCentral;
    
    private IStrategieCouleurs palette;
    
    private String path;

    private String nom;
    
    private ImageBuilder() {
        
    }
    
    public static ImageBuilder newInstance() {
        return new ImageBuilder();
    }
    
    public ImageBuilder withWidth(int width) {
        this.width = width;
        return this;
    }
    
    public ImageBuilder withHeight(int height) {
        this.height = height;
        return this;
    }
    
    public ImageBuilder withPointCentral(IPoint central) {
        this.pointCentral = pointCentral;
        return this;
    }
    
    public ImageBuilder withPalette(IStrategieCouleurs palette) {
        this.palette = palette;
        return this;
    }
    
    public ImageBuilder withPath(String path) {
        this.path = path;
        return this;
    }
    
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
   
    public void generation() throws IOException {
        Complex c = new Complex(0.4,  0.6);
        int nbIt = 0;
        int maxIt = 0;
        PlanComplex plan = new PlanComplex(width, height);
        IStrategieSuite s = null;
        SuiteIterator it;
        PlanComplexZoomDecorator planZoom = new PlanComplexZoomDecorator(c, plan, width, height);
        IFractalImage image = new AdaptateurImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                IComplex complex = planZoom.asComplex(j, i);
                if ("julia".equalsIgnoreCase(nom)) {
 ;                  s = new SuiteJulia(c, complex, 124);
                    it = (SuiteIterator) ((SuiteJulia)(s)).iterator();
                    maxIt = ((SuiteJulia)(s)).getMaxIteration();
                } else if ("mandelbrot".equalsIgnoreCase(nom)) {
                    s = new SuiteMandelbrot(complex, 124);
                    it = (SuiteIterator) ((SuiteMandelbrot)(s)).iterator();
                    maxIt = ((SuiteMandelbrot)(s)).getMaxIteration();
                } else {
                    throw new IllegalArgumentException();
                }
                while (it.hasNext()) it.next();
                image.setColor(j, i, palette.palette(nbIt, maxIt));
            }
        }
        image.saveAs(path);
    }
 
}

