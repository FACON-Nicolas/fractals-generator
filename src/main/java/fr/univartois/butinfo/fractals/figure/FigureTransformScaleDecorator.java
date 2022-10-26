/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;


/**
 * Le type FigureTransformDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FigureTransformScaleDecorator extends FigureDecorator {
    
    private double scale;
    
    public FigureTransformScaleDecorator(IFigure figure) {
        this(figure, 1);
    }
    
    public FigureTransformScaleDecorator(IFigure figure, double scale) {
        super(figure);
        this.scale = scale;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figure.IFigure#getSVG()
     */
    @Override
    public String getSVG() {
        return "<g transform=\"scale(" + scale + ")\">"
                + getFigure().toString() + "</g>";
    }

}

