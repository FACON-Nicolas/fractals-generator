package fr.univartois.butinfo.fractals;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.Point;

public class SuiteChaotiqueCirculaire implements IStrategieSuiteChaotique{
    @Override
    public IPoint derterminerTermeSuivant(IPoint pointAnterieur) {
        double xAnt = pointAnterieur.getX();
        double yAnt = pointAnterieur.getY();
        return new Point(
                xAnt,
                yAnt + (xAnt * Math.sin(2*Math.PI*yAnt)) / 2 * Math.PI + 1.0/3.0
        );
    }
}
