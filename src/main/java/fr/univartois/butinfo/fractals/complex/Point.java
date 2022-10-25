/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type Point
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class Point implements IPoint {
    
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#getX()
     */
    @Override
    public double getX() {
        return x;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#getY()
     */
    @Override
    public double getY() {
        return y;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#distance(fr.univartois.butinfo.fractals.complex.IPoint)
     */
    @Override
    public double distance(IPoint other) {
        return Math.sqrt(Math.pow((x-other.getX()), 2)+Math.pow((y-other.getY()), 2));
    }
    
    public IComplex fromPointToComplex() {
        return new Complex(x, y);
    }

}

