/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;

import java.awt.Color;

/**
 * Le type FigureCarre
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FigureCarre extends FigureRectangle {

    /**
     * Crée une nouvelle instance de FigureCarre.
     * @param x Une abscisse.
     * @param y Une ordonnée.
     * @param color Une couleur.
     * @param width La largeur de la figure.
     */
    public FigureCarre(int x, int y, Color color, int width) {
        // TODO Auto-generated constructor stub.
        super(x, y, color, width, width);
    }

}

