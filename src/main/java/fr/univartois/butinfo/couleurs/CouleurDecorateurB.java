package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class CouleurDecorateurB extends CouleurDecorateur{
	/**
	 * Crée une instance de la classe 
	 * @param palette une palette de couleurs
	 */
	public CouleurDecorateurB(IStrategieCouleurs palette) {
		super(palette);
	}
	/**
	 * Crée une palette de couleur et met un masque sur la couleur Bleue
	 * @param nbItMax le nombre d'itérations max
	 * @param nbIterations le nombre d'itérations
	 */
	@Override
	public Color palette(int nbItMax, int nbIterations) {
		Color couleur = palette.palette(nbItMax, nbIterations);
		return new Color(couleur.getRed(),couleur.getGreen(),0);
	}
}
