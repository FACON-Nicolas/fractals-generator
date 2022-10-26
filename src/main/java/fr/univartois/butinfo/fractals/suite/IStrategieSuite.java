package fr.univartois.butinfo.fractals.suite;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Suis le patron de conception de la stratégie pour représenter les suites.
 */
public interface IStrategieSuite {
    IComplex derterminerTermeSuivant(IComplex termeAnterieur);

}
