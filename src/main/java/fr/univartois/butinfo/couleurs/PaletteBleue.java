package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class PaletteBleue implements IStrategieCouleurs{
	
	/**
	 * Crée une palette de couleur (ici:bleue)
	 * @param nbItMax le nombre d'itérations max
	 * @param nbIterations le nombre d'itérations
	 */
	@Override
	public Color palette(int nbItMax, int nbIterations) {
		float ratio =(float) nbIterations/nbItMax;
		return new Color(ratio/2,ratio,ratio);
	}

}
