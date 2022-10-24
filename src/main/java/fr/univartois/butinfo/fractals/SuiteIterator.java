package fr.univartois.butinfo.fractals;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;

/**
 * Utilisation des iterator pour pouvoir parcourir les listes.
 */
public class SuiteIterator implements Iterator<IComplex> {

    private final IStrategieSuite suite;
    private IComplex terme;
    private final int interationMax;

    private int nbInteration;

    public SuiteIterator(IStrategieSuite suite, IComplex terme, int interationMax) {
        this.suite = suite;
        this.terme = terme;
        this.interationMax = interationMax;
        nbInteration = 0;
    }

    @Override
    public boolean hasNext() {
        return (terme.abs() > 2) || (nbInteration < interationMax);
    }

    @Override
    public IComplex next() {
        terme = suite.derterminerTermeSuivant(terme);
        if (hasNext()){
            nbInteration++;
            return terme;
        }
        return null;
    }
}
