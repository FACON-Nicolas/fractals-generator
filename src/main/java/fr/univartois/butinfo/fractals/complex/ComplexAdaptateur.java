/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type ComplexAdaptateur
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class ComplexAdaptateur implements IPoint {
    
    private final IComplex complex;
    
    /**
     * Crée une nouvelle instance de ComplexAdaptateur.
     */
    public ComplexAdaptateur(IComplex complex) {
        this.complex = complex;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#getX()
     */
    @Override
    public double getX() {
        return this.complex.getRealPart();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#getY()
     */
    @Override
    public double getY() {
        return this.complex.getImaginaryPart();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.complex.IPoint#distance(fr.univartois.butinfo.fractals.complex.IPoint)
     */
    @Override
    public double distance(IPoint other) {
        double x = Math.pow(getX() - other.getX(), 2);
        double y = Math.pow(getY() - other.getY(), 2);
        return Math.sqrt(x + y);
    }

    /**
     * Renvoie le nombre complexe du point
     * @return un nombre complexe
     */
    public IComplex toComplex(){
        return complex;
    }

}

