package fr.univartois.butinfo.fractals;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.Point;

import java.util.Iterator;

public class SuiteChaotiqueFeigenbaum implements IStrategieSuiteChaotique, Iterable<IPoint>{

    private final IPoint premierPoint;

    public SuiteChaotiqueFeigenbaum(IPoint premierPoint) {
        this.premierPoint = premierPoint;
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
        // TODO Après la classe Iterator
        return null;
    }
}
