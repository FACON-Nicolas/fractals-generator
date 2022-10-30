package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IPoint;

public interface IStrategieSuiteChaotique extends Iterable<IPoint>{

    IPoint derterminerTermeSuivant(IPoint pointAnterieur);
}
