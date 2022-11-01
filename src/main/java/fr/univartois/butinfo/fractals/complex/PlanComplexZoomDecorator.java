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
 * Le type PlanComplexZoomDecorator
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class PlanComplexZoomDecorator extends PlanComplexDecorator {

    private double constante;
    
    /**
     * Crée une nouvelle instance de PlanComplexZoomDecorator.
     * @param plan Un plan complexe.
     * @param width La largeur du plan.
     * @param height La hauteur du plan.
     */
    public PlanComplexZoomDecorator(double constante, IPlanComplex plan, int width, int height) {
        super(plan, width, height);
        this.constante = constante;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return super.asComplex(row, column).multiply(constante);
    }

    @Override
    public Pixel asPixel(IComplex complex, IFractalImage fractalImage) {
        return plan.asPixel(complex.divide(new Complex(constante, 0)), fractalImage);
    }

    @Override
    public Pixel asPixel(IPoint point, IFractalImage fractalImage) {
        return plan.asPixel(new Point(
                point.getX() / constante,
                point.getY() / constante),
                fractalImage);
    }

}

