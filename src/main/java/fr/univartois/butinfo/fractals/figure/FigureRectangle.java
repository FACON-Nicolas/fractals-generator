package fr.univartois.butinfo.fractals.figure;

import java.awt.*;

public class FigureRectangle extends AbstractFigure{

    protected final int width;

    protected final int height;

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
                "stroke=\"" + color + "\" " +
                "/>";
    }
}
