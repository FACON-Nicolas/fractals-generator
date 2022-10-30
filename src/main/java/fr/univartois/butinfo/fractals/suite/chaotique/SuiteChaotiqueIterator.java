package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;

import java.util.Iterator;

/**
 * L'itérateur des suites chaotiques.
 *
 * @author Arnaud
 *
 * @version 0.1.0
 */
public class SuiteChaotiqueIterator implements Iterator<IPoint> {

    /**
     * Une suite Chaotique
     */
    private final IStrategieSuiteChaotique suite;

    /**
     * Le nombre d'itérations maximum de la suite.
     */
    private final int interationMax;

    /**
     * Le nombre d'itération.
     */
    private int nbInteration;

    /**
     * Un point.
     */
    private IPoint point;

    /**
     * Crée une nouvelle instance de SuiteChaotiqueIterator.
     * @param suite Une suite.
     * @param interationMax Le nombre d'itérations max de la suite.
     * @param point Un point.
     */
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
