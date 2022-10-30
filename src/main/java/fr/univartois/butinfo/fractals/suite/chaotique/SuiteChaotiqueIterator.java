package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;

import java.util.Iterator;

public class SuiteChaotiqueIterator implements Iterator<IPoint> {

    private final IStrategieSuiteChaotique suite;

    private final int interationMax;

    private int nbInteration;

    private IPoint point;

    public SuiteChaotiqueIterator(IStrategieSuiteChaotique suite, int interationMax, IPoint point) {
        this.suite = suite;
        this.point = point;
        this.interationMax = interationMax;
        nbInteration = 0;
    }

    @Override
    public boolean hasNext() {
        return nbInteration < interationMax;
    }

    @Override
    public IPoint next() {
        if (hasNext()){
            nbInteration++;
            point = suite.derterminerTermeSuivant(point);
            return point;
        }
        return null;
    }

    /**
     * Donne l'attribut nbInteration de cette instance de SuiteChaotiqueIterator.
     *
     * @return L'attribut nbInteration de cette instance de SuiteChaotiqueIterator.
     */
    public int getNbInteration() {
        return nbInteration;
    }
}
