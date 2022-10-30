package fr.univartois.butinfo.fractals.figure;

import java.awt.*;

public class FigureRectangle extends AbstractFigure{

    protected final int width;

    protected final int height;

    /**
     * Crée une nouvelle instance de FigureRectangle.
     * @param x Une abscisse.
     * @param y Une ordonnée.
     * @param color Une couleur.
     * @param width La largeur de la figure.
     * @param height La hauteur de la figure.
     */
    public FigureRectangle(int x, int y, Color color, int width, int height) {
        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    @Override
    public final String getSVG() {
        return "<rect " +
                "x=\"" + x + "\" " +
                "y=\"" + y + "\" " +
                "width=\"" + width + "\" " +
                "height=\"" + height + "\" " +
                "fill=\"" + "rgb("+ color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")"+ "\" " +
                "/>";
    }
    
    
    /**
     * Donne l'attribut width de cette instance de FigureRectangle.
     *
     * @return L'attribut width de cette instance de FigureRectangle.
     */
    public int getWidth() {
        return width;
    }
    
    
    /**
     * Donne l'attribut height de cette instance de FigureRectangle.
     *
     * @return L'attribut height de cette instance de FigureRectangle.
     */
    public int getHeight() {
        return height;
    }
}
