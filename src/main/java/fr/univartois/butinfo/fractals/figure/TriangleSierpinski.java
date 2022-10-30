/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

/**
 * Le type TriangleSierpinski
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class TriangleSierpinski extends AbstractFractalesSVG {
    
    
    
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
        if (iterations == getIterations()) return file;
        creerFormesBase(file, figure);
        int x1 = ((LineFigure)figure).x;
        int y1 = ((LineFigure)figure).y;
        int x2 = (int) x1 + ((LineFigure)figure).getLongueur();
        int y2 = y1;
        int x3 = (x1 + x2) / 2;
        int y3 = y1 + (int) (Math.sqrt(3) * (((LineFigure)figure).getLongueur() / 2));
        
        formerFractale(file, new LineFigure(x1, y1, Color.black, x2, y2), iterations+1);
        formerFractale(file, new LineFigure(x1, y1, Color.black, x3, y3), iterations+1);
        formerFractale(file, new LineFigure(x2, y2, Color.black, x3, y3), iterations+1);
        return file;
    }

    
    public static void main(String[] args) {
        TriangleSierpinski t = new TriangleSierpinski(600, 600, new LineFigure(150,300, Color.black, 450, 300), 5);
        try {
            t.creerFractalesSvg();
        } catch (IOException e) {
            System.err.println("oops");
        }
    }

}

