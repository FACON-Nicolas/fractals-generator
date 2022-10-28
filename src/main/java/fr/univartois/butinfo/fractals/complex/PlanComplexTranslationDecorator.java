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

    /**
     * Un nombre complex.
     */
    private final IComplex constante;
    
    /**
     * Crée une nouvelle instance de PlanComplexTranslationDecorator.
     * 
     * @param plan Un plan complex.
     * 
     * @param width La largeur du plan.
     * 
     * @param height La hauteur du plan.
     * @param constante Un nombre complexe constant.
     */
    protected PlanComplexTranslationDecorator(IPlanComplex plan, int width, int height, IComplex constante) {
        super(plan, width, height);
        this.constante = constante;
    }


    @Override
    public IComplex asComplex(int row, int column) {
        return super.asComplex(row, column).add(constante);
    }

}

