/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

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
    private final int width;
    
    /**
     * largeur plan
     */
    private final int height;
    
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
        double re = (column + 0.5) - (width / 2.0);
        double im = (height / 2.0) -  (row + 0.5);
        return new Complex(re, im);
    }

    @Override
    /**
     * Cette méthode permet de déterminer a quel pixel correspond un nombre complexe.
     * @param complex un complexe.
     * @param fractalImage une image de fractale.
     * @return un pixel.
     */
    public Pixel asPixel(IComplex complex, IFractalImage fractalImage){
        int x = (int) (- complex.getImaginaryPart() + (height / 2.0) - 0.5);
        int y = (int) (complex.getRealPart() + (width / 2.0) - 0.5);
        if ((x <= fractalImage.getWidth()) && (y <= fractalImage.getHeight()) && x >= 0 && y >= 0)
            return new Pixel(fractalImage, x, y);
        return null;
    }

    @Override
    /**
     * Cette méthode permet de déterminer a quel pixel correspond un point du plan.
     * @param point un point du plan.
     * @param fractalImage une image de fractale.
     * @return un pixel.
     */
    public Pixel asPixel(IPoint point, IFractalImage fractalImage){
        int x = (int) (- point.getX() + (height / 2.0) - 0.5);
        int y = (int) (point.getY() + (width / 2.0) - 0.5);
        if ((x < fractalImage.getWidth()) && (y < fractalImage.getHeight()) && x >= 0 && y >= 0)
            return new Pixel(fractalImage, x, y);
        return null;
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

