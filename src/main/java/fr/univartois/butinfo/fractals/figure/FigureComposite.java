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
    private final List<IFigure> figures;
    
    public FigureComposite(double width, double height) {
        figures = new ArrayList<IFigure>();
        this.width = width;
        this.height = height;
    }
    
    public void add(IFigure figure) {
        figures.add(figure);
    }
    
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
        String debut = "<svg width=\"" + width + "\" height=\"" + height
                + "xmlns=\"http://www.w3.org/2000/svg\">";
        
        String fin = "</svg>";
        
        StringBuffer s = new StringBuffer();
        
        for (IFigure figure : figures)
            s.append(figure + "\n");
        
        return debut + s.toString() + fin;
    }
    
    

}

