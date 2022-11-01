package fr.univartois.butinfo.fractals.suite.simple;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Suis le patron de conception de la stratégie pour représenter les suites.
 */
public interface IStrategieSuite {
    /**
      * Permet de déterminer le terme suivant d'une suite.
     * @param termeAnterieur le terme antérieur de la suite.
     * @return Le point suivant de la suite.
     */
    IComplex derterminerTermeSuivant(IComplex termeAnterieur);

}
