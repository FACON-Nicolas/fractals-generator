/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;


/**
 * Le type FigureTransformRotateDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FigureTransformRotateDecorator extends FigureDecorator {
    
    /**
     * L'angle de rotation.
     */
    private double rotation;
    
    /**
     * Crée une nouvelle instance de FigureTransformRotateDecorator.
     * @param figure Une figure.
     */
    public FigureTransformRotateDecorator(IFigure figure) {
        this(figure, 0);
    }
    
    /**
     * Crée une nouvelle instance de FigureTransformRotateDecorator.
     * @param figure Une figure.
     * @param rotation Un angle de rotation.
     */
    public FigureTransformRotateDecorator(IFigure figure, double rotation) {
        super(figure);
        this.rotation = rotation;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figure.IFigure#getSVG()
     */
    @Override
    public String getSVG() {
        return "<g transform=\"rotation(" + rotation + ")\">"
                + getFigure().toString() + "</g>";
    }

}