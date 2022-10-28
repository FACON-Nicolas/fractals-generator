/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;

import java.awt.Color;

/**
 * Le type LineFigure
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class LineFigure extends AbstractFigure {
    
    /**
     * L'attribut width...
     */
    private int x2;
    
    /**
     * L'attribut height...
     */
    private int y2;

    /**
     * Crée une nouvelle instance de Rectangle.
     * @param x
     * @param y
     * @param couleur
     * @param width
     * @param height
     */
    public LineFigure(int x, int y, Color couleur, int x2, int y2) {
        super(x, y, couleur);
        this.x2 = x2;
        this.y2 = y2;
    }
    
    /**
     * Donne la width
     * @return width
     */
    public double getX2() {
        return x2;
    }

    /**
     * Donne la height
     * @return height
     */
    public double getY2() {
        return y2;
    }


    @Override
    public String getSVG() {
        return "<line x1=\""+this.getX()+"\" y1=\""+this.getY()+"\" x2=\""+this.getX2()+"\" y2=\""+this.getY2()+"\" fill=\"" + "rgb("+ color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")"+ "\"/>";
    }

}

