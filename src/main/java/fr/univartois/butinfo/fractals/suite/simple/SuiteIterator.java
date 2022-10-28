package fr.univartois.butinfo.fractals.suite.simple;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;

/**
 * Utilisation des iterator pour pouvoir parcourir les listes.
 */
public class SuiteIterator implements Iterator<IComplex> {

    /**
     * Une suite
     */
    private final IStrategieSuite suite;
    /**
     * Un terme de la suite.
     */
    private IComplex terme;
    /**
     * Le nombre d'itérations max de la suite.
     */
    private final int iterationMax;

    private int nbInteration;

    /**
     * Crée une nouvelle instance de SuiteIterator.
     * @param suite Le nom d'une suite.
     * @param terme Un terme de la suite.
     * @param iterationMax Le nombre d'itérations maximum.
     */
    public SuiteIterator(IStrategieSuite suite, IComplex terme, int iterationMax) {
        this.suite = suite;
        this.terme = terme;
        this.iterationMax = iterationMax;
        nbInteration = 0;
    }

    @Override
    public boolean hasNext() {
        return (terme.abs() <= 2) && (nbInteration < iterationMax);
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
    
    
    /**
     * Donne l'attribut nbInteration de cette instance de SuiteIterator.
     *
     * @return L'attribut nbInteration de cette instance de SuiteIterator.
     */
    public int getNbInteration() {
        return nbInteration;
    }
}
