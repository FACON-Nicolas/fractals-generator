package fr.univartois.butinfo.couleurs;

import java.awt.Color;
/**
 * 
 * @author Elsa
 *On utilise un patron de stratégie.
 */
public interface IStrategieCouleurs {

	public Color palette(int nbItMax, int nbIterations);
	
}
