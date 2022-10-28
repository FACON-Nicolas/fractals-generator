/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;


/**
 * Le type FigureDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public abstract class FigureDecorator implements IFigure {
    
    private final IFigure figure;
    
    public FigureDecorator(IFigure figure) {
        this.figure = figure;
    }
    
    protected IFigure getFigure() {
        return figure;
    }

}

