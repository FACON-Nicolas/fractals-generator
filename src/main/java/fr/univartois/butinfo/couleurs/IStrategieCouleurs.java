package fr.univartois.butinfo.couleurs;

import java.awt.Color;
/**
 * 
 * @author Elsa
 *On utilise un patron de stratégie.
 */
public interface IStrategieCouleurs {

	/**
	 * @param nbItMax le nombre d'itérations maximium.
	 * @param nbIterations le nombre actuel d'itérations.
	 * @return Color instance de la classe Color.
	 */
	public Color palette(int nbItMax, int nbIterations);
	
}
