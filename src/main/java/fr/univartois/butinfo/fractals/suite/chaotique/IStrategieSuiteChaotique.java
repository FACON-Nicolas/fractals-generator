package fr.univartois.butinfo.fractals.suite.chaotique;

import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.IPoint;

public interface IStrategieSuiteChaotique {

    /**
     * Permet de déterminer le point suivant d'une suite.
     * @param pointAnterieur le point antérieur de la suite.
     * @return Le point suivant de la suite.
     */
    IPoint derterminerTermeSuivant(IPoint pointAnterieur);
}
