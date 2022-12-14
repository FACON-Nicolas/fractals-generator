/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.suite.simple;

import java.util.Iterator;

import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.suite.simple.IStrategieSuite;
import fr.univartois.butinfo.fractals.suite.simple.SuiteIterator;

/**
 * Le type SuiteMandelbrot
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class SuiteMandelbrot implements IStrategieSuite, Iterable<IComplex> {
    
    /**
     * Un complex.
     */
    private IComplex z;
    /**
     * Le nombre maximum d'itérations.
     */
    private int maxIteration;
    /**
     * Le premier terme de la suite.
     */
    private IComplex premierTerme;
    
    /**
     * Crée une nouvelle instance de SuiteMandelbrot.
     * @param z Un complexe.
     * @param maxIteration Le nombre maximum d'itérations.
     */
    public SuiteMandelbrot(IComplex z, int maxIteration) {
        this.z = z;
        this.maxIteration = maxIteration;
        premierTerme = z.multiply(z).add(z);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.suite.simple.IStrategieSuite#derterminerTermeSuivant(fr.univartois.butinfo.fractals.complex.IComplex)
     */
    @Override
    public IComplex derterminerTermeSuivant(IComplex termeAnterieur) {
        IComplex terme = termeAnterieur.multiply(termeAnterieur).add(z);
        return terme;
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
     * Donne l'attribut maxIteration de cette instance de SuiteMandelbrot.
     *
     * @return L'attribut maxIteration de cette instance de SuiteMandelbrot.
     */
    public int getMaxIteration() {
        return maxIteration;
    }

}

