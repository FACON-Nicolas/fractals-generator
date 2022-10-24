package fr.univartois.butinfo.fractals;

import fr.univartois.butinfo.fractals.complex.IComplex;

public interface IStrategieSuite {

    // Patron de conception pour les suites générales : stratégie

    IComplex derterminerTermeSuivant(IComplex termeAnterieur);

}
