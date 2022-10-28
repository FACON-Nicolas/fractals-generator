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
    
    /**
     * Une figure.
     */
    private final IFigure figure;
    
    /**
     * Crée une nouvelle instance de FigureDecorator.
     * @param figure Une figure
     */
    public FigureDecorator(IFigure figure) {
        this.figure = figure;
    }
    
    /**
     * méthode permettant de retourner une figure.
     * @return figure Une figure
     */
    protected IFigure getFigure() {
        return figure;
    }

}

