package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.IPoint;

public interface IStrategieSuiteChaotique {

    IPoint derterminerTermeSuivant(IPoint pointAnterieur);
}
