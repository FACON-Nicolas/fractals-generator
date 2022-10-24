/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type PlanComplexZoomDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class PlanComplexZoomDecorator extends PlanComplexDecorator {

    private IComplex constante;
    
    /**
     * Crée une nouvelle instance de PlanComplexZoomDecorator.
     * @param plan
     * @param width
     * @param height
     */
    protected PlanComplexZoomDecorator(IComplex constante, IPlanComplex plan, int width, int height) {
        // TODO Auto-generated constructor stub.
        super(plan, width, height);
        this.constante = constante;
    }
    
    public IComplex asComplex(int row, int column) {
        return super.asComplex(row, column).multiply(column);
    }

}

