package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.Point;

import java.util.Iterator;

public class SuiteChaotiqueCirculaire implements IStrategieSuiteChaotique, Iterable<IPoint>{

    private final IPoint premierPoint;
    private final int interationMax;

    public SuiteChaotiqueCirculaire(IPoint premierPoint, int interationMax) {
        this.premierPoint = premierPoint;
        this.interationMax = interationMax;
    }

    @Override
    public IPoint derterminerTermeSuivant(IPoint pointAnterieur) {
        double xAnt = pointAnterieur.getX();
        double yAnt = pointAnterieur.getY();
        return new Point(
                xAnt,
                yAnt + (xAnt * Math.sin(2*Math.PI*yAnt)) / 2 * Math.PI + 1.0/3.0
        );
    }

    @Override
    public Iterator<IPoint> iterator() {
        return new SuiteChaotiqueIterator(this, interationMax, premierPoint);
    }

    /**
     * Donne l'attribut maxIteration de cette instance de SuiteChaotiqueCirculaire.
     *
     * @return L'attribut maxIteration de cette instance de SuiteChaotiqueCirculaire.
     */
    public int getMaxIteration() {
        return interationMax;
    }
}
