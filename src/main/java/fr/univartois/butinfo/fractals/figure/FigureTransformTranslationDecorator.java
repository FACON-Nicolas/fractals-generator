/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;


/**
 * Le type FigureTransformTranslationDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FigureTransformTranslationDecorator extends FigureDecorator {
    
    private double translationX;
    private double translationY;
    
    public FigureTransformTranslationDecorator(IFigure figure, double translationX, double translationY) {
        super(figure);
        this.translationX = translationX;
        this.translationY = translationY;
    }
    
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figure.IFigure#getSVG()
     */
    @Override
    public String getSVG() {
        return "<g transform=\"translate(" + translationX + ", " + translationY + ")\">"
                + getFigure().toString() + "</g>";
    }

}

