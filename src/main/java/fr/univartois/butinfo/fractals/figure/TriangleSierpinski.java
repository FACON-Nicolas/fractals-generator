/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Le type TriangleSierpinski
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class TriangleSierpinski extends AbstractFractalesSVG {
    
    private List<LineFigure> figures = new ArrayList<>();
    
    public TriangleSierpinski(int width, int height, IFigure figure, int iteration) {
        super(width, height, figure, iteration);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figure.AbstractFractalesSVG#formerFractale(java.io.Writer, fr.univartois.butinfo.fractals.figure.IFigure, int)
     */
    @Override
    public Writer formerFractale(Writer file, IFigure figure, int iterations) throws IOException {
        LineFigure fig = (LineFigure) figure;
        triangle(fig.x, fig.y, fig.getLongueur(), iterations);
        for (IFigure f : figures)
            creerFormesBase(file, f);
        return file;
    }
    
    public void triangle(double x, double y, double longueur, int n) {

        if (n == getIterations()) return;
        
        double x1 = x;
        double y1 = y;
        double x2 = x1 + longueur;
        double y2 = y1;
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + (Math.sqrt(3) * longueur / 2);

        figures.add(new LineFigure((int)x1,(int) y1, Color.black,(int) x2, (int) y2));
        figures.add(new LineFigure((int)(x1),(int) (y1), Color.black, (int) x3, (int) y3));
        figures.add(new LineFigure((int)(x2),(int) (y2), Color.black,(int) x3, (int) y3));

        triangle(x1, y1, longueur / 2.0, n + 1);
        triangle((x1 + x2) / 2.0, (y1 + y2) / 2.0, longueur / 2.0, n + 1);
        triangle((x1 + x3) / 2.0, (y1 + y3) / 2.0, longueur / 2.0, n + 1);
    }
    
    public static void main(String[] args) {
        TriangleSierpinski t = new TriangleSierpinski(2048, 2048, new LineFigure(50, 10, Color.black, 2000, 10), 10);
        try {
            t.creerFractalesSvg();
        } catch (IOException e) {
            System.err.println("oops");
        }
    }

}

