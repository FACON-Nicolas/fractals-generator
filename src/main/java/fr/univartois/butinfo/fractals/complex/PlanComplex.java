/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type PlanComplex
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class PlanComplex implements IPlanComplex {
    
    /**
     * longueur plan
     */
    private int width;
    
    /**
     * largeur plan
     */
    private int height;
    
    /**
     * 
     * Crée une nouvelle instance de PlanComplex.
     * 
     * @param width longueur plan
     * 
     * @param height largeur plan
     */
    public PlanComplex(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#asComplex(int, int)
     */
    @Override
    public IComplex asComplex(int row, int column) {
        double re = (column + 0.5) - (width / 2);
        double im = (height / 2) -  (row + 0.5);
        return new Complex(re, im);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#getWidth()
     */
    @Override
    public int getWidth() {
        return width;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPlanComplex#getHeight()
     */
    @Override
    public int getHeight() {
        return height;
    }

}

