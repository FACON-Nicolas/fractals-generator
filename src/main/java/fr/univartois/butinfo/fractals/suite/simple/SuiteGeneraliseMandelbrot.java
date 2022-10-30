/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suite.simple;

import java.util.Iterator;
import java.util.function.BinaryOperator;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Le type SuiteMandelbrot
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class SuiteGeneraliseMandelbrot implements IStrategieSuite, Iterable<IComplex> {

    private IComplex z;
    private final int maxIteration;
    private IComplex premierTerme;

    /**
     * Opération qui va être utilisée pour déterminer les termes de la suite.
     */
    private final BinaryOperator<IComplex> fonction;

    public SuiteGeneraliseMandelbrot(IComplex z, int maxIteration, BinaryOperator<IComplex> fonction) {
        this.z = z;
        this.maxIteration = maxIteration;
        premierTerme = z.multiply(z).add(z);
        this.fonction = fonction;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.suite.simple.IStrategieSuite#derterminerTermeSuivant(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex derterminerTermeSuivant(IComplex termeAnterieur) {
        return fonction.apply(termeAnterieur, z);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, z, maxIteration);
    }
    
    
    /**
     * Donne l'attribut maxIteration de cette instance de SuiteGeneraliseMandelbrot.
     *
     * @return L'attribut maxIteration de cette instance de SuiteGeneraliseMandelbrot.
     */
    public int getMaxIteration() {
        return maxIteration;
    }

}

