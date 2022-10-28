/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type IPoint
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public interface IPoint {
    
    /**
     * donne la valeur de X
     * 
     * @return valeur de X
     */
    double getX();
    
    /**
     * donne la valeur de Y
     * 
     * @return la valeur de Y
     */
    double getY();
    
    /**
     * calcule la distance entre deux points.
     * 
     * formule (sqrt((x - other.x)**2 + (y - other.y) **2).
     * 
     * @param other autre point
     * 
     * @return distance entre this et other.
     */
    double distance(IPoint other);

}

