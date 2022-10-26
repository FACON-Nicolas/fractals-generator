/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


/**
 * Le type PlanComplexTranslationDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class PlanComplexTranslationDecorator extends PlanComplexDecorator {

    private final IComplex constante;
    
    /**
     * Crée une nouvelle instance de PlanComplexTranslationDecorator.
     * 
     * @param plan
     * 
     * @param width
     * 
     * @param height
     */
    protected PlanComplexTranslationDecorator(IPlanComplex plan, int width, int height, IComplex constante) {
        // TODO Auto-generated constructor stub.
        super(plan, width, height);
        this.constante = constante;
    }


    public IComplex asComplex(int row, int column) {
        return super.asComplex(row, column).add(constante);
    }

}

