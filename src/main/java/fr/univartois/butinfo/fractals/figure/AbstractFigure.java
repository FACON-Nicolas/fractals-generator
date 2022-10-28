package fr.univartois.butinfo.fractals.figure;

import java.awt.*;

public abstract class AbstractFigure implements IFigure {

    protected final int x;

    protected final int y;

    protected final Color color;

    public AbstractFigure(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    
    /**
     * Donne l'attribut x de cette instance de AbstractFigure.
     *
     * @return L'attribut x de cette instance de AbstractFigure.
     */
    public int getX() {
        return x;
    }
    
    
    /**
     * Donne l'attribut y de cette instance de AbstractFigure.
     *
     * @return L'attribut y de cette instance de AbstractFigure.
     */
    public int getY() {
        return y;
    }
    
    
    /**
     * Donne l'attribut color de cette instance de AbstractFigure.
     *
     * @return L'attribut color de cette instance de AbstractFigure.
     */
    public Color getColor() {
        return color;
    }
}
