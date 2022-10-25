package fr.univartois.butinfo.fractals.figure;

import java.awt.*;

public abstract class AbstractFigure {

    protected final int x;

    protected final int y;

    protected final java.awt.Color color;

    public abstract String getSVG();

    public AbstractFigure(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
