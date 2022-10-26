package fr.univartois.butinfo.fractals.suite;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;

public class SuiteJulia implements IStrategieSuite, Iterable<IComplex> {

    /**
     * Premier terme de la suite
     */
    private final IComplex z;
    private final int maxIteration;
    /**
     * Constante utilisée dans les calculs
     */
    private final IComplex c;
    public SuiteJulia(IComplex z, IComplex c, int maxIteration) {
        this.c = c;
        this.z = z;
        this.maxIteration = maxIteration;
    }

    @Override
    public IComplex derterminerTermeSuivant(IComplex termeAnterieur) {
        return termeAnterieur.multiply(termeAnterieur).add(c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, z, maxIteration);
    }
    
    
    /**
     * Donne l'attribut maxIteration de cette instance de SuiteJulia.
     *
     * @return L'attribut maxIteration de cette instance de SuiteJulia.
     */
    public int getMaxIteration() {
        return maxIteration;
    }
}
