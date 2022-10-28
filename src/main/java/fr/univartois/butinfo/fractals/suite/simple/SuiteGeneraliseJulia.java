package fr.univartois.butinfo.fractals.suite.simple;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

/**
 * La type Suite Generalisée de Julia
 *
 * @author Arnaud
 *
 * @version 0.1.0
 */
public class SuiteGeneraliseJulia implements IStrategieSuite, Iterable<IComplex> {

    /**
     * Premier terme de la suite
     */
    private final IComplex z;
    /**
     * Le nombre maximum d'itérations.
     */
    private final int maxIteration;

    /**
     * Constante utilisée dans les calculs
     */
    private final IComplex c;

    /**
     * Opération qui va être utilisée pour déterminer les termes de la suite.
     */
    private final BinaryOperator<IComplex> fonction;

    /**
     * Crée une nouvelle instance de SuiteGeneraliseJulia.
     * @param z Un complexe.
     * @param c Un complexe.
     * @param maxIteration Le nombre maximum d'itérations.
     * @param fonction Un binaryOperator.
     */
    public SuiteGeneraliseJulia(IComplex z, IComplex c, int maxIteration, BinaryOperator<IComplex> fonction) {
        this.c = c;
        this.z = z;
        this.maxIteration = maxIteration;
        this.fonction = fonction;
    }

    @Override
    public IComplex derterminerTermeSuivant(IComplex termeAnterieur) {
        return fonction.apply(termeAnterieur, c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, z, maxIteration);
    }

}
