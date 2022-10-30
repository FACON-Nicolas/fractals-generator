package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.complex.Point;

import java.util.Iterator;

/**
 * Création d'une Suite Chaotique de Feigenbaum.
 *
 * @author Arnaud
 *
 * @version 0.1.0
 */
public class SuiteChaotiqueFeigenbaum implements IStrategieSuiteChaotique, Iterable<IPoint>{

    /**
     * Le premier point avec lequel on calcule le reste de la suite.
     */
    private final IPoint premierPoint;
    /**
     * Le nombre d'itérations maximum de la suite.
     */
    private final int interationMax;

    /**
     * Crée une nouvelle instance de SuiteChaotiqueFeigenbaum.
     * @param premierPoint Le premier point de la suite.
     * @param interationMax Le nombe d'itérations maximum.
     */
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
}
