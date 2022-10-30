/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.complex;


import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

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
        super(plan, width, height);
        this.constante = constante;
    }


    @Override
    public IComplex asComplex(int row, int column) {
        return super.asComplex(row, column).add(constante);
    }

    @Override
    public Pixel asPixel(IComplex complex, IFractalImage fractalImage) {
        return plan.asPixel(complex.subtract(constante), fractalImage);
    }

    @Override
    public Pixel asPixel(IPoint point, IFractalImage fractalImage) {
        return plan.asPixel(new Point(
                point.getX() - constante.getRealPart(),
                point.getY() - constante.getImaginaryPart()),
                fractalImage);
    }

}

