package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.Point;

import java.util.Iterator;

public class SuiteChaotiqueFeigenbaum implements IStrategieSuiteChaotique, Iterable<IPoint>{

    private final IPoint premierPoint;
    private final int interationMax;

    public SuiteChaotiqueFeigenbaum(IPoint premierPoint, int interationMax) {
        this.premierPoint = premierPoint;
        this.interationMax = interationMax;
    }

    @Override
    public IPoint derterminerTermeSuivant(IPoint pointAnterieur) {
        return new Point(
                pointAnterieur.getX(),
                (pointAnterieur.getY() * pointAnterieur.getX()) * (1 - pointAnterieur.getY())
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
