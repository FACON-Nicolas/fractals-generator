package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class CouleurDecorateurR extends CouleurDecorateur{
	/**
	 * Crée une instance de la classe 
	 * @param palette une palette de couleurs
	 */
	public CouleurDecorateurR(IStrategieCouleurs palette) {
		super(palette);
	}
	
	/**
	 * Crée une palette de couleur et met un masque sur la couleur verte
	 * @param nbItMax le nombre d'itérations max
	 * @param nbIterations le nombre d'itérations
	 */
	@Override
	public Color palette(int nbItMax, int nbIterations) {
		Color couleur = palette.palette(nbItMax, nbIterations);
		return new Color(0,couleur.getGreen(),couleur.getBlue());
	}
}
