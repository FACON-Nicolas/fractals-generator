/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.figure;

import java.util.ArrayList;
import java.util.List;

/**
 * Le type FigureComposite
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FigureComposite implements IFigure {
    
    private double width;
    private double height;
    /**
     * Une liste de figures.
     */
    private final List<IFigure> figures;
    
    /**
     * Crée une nouvelle instance de FigureComposite.
     * @param width La largeur de la figure.
     * @param height La hauteur de la figure.
     */
    public FigureComposite(double width, double height) {
        figures = new ArrayList<IFigure>();
        this.width = width;
        this.height = height;
    }
    
    /**
     * Méthode permettant d'ajouter une figure à une liste de figures.
     * @param figure Une figure.
     */
    public void add(IFigure figure) {
        figures.add(figure);
    }
    
    /**
     * Méthode permettant d'enlever une figure de la liste de figures.
     * @param figure Une figure
     */
    public void remove(IFigure figure) {
        figures.remove(figure);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.figure.IFigure#getSVG()
     */
    @Override
    public String getSVG() {
        
        StringBuffer s = new StringBuffer();
        
        for (IFigure figure : figures)
            s.append(figure + "\n");
        
        return s.toString();
    }
    
    

}

