/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type IplanComplex
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public interface IPlanComplex {
    
    /**
     * permet de transformer un pixel en nombre complexe.
     * 
     * la ligne représente la partie réelle quand la colonne
     * elle représente la partie imaginaire du nombre complexe.
     * 
     * @param row num ligne (re)
     * 
     * @param column num colonne(im)
     * 
     * @return nombre complexe a partir d'un pixel.
     */
    IComplex asComplex(int row, int column);
    
    /**
     * permet d'obtenir la taille
     * 
     * @return valeur de la taille
     */
    int getWidth();
    
    /**
     * permet d'obtenir la largeur
     * 
     * @return valeur de la largeur
     */
    int getHeight();

}

