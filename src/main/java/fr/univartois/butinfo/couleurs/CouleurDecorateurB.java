package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class CouleurDecorateurB extends CouleurDecorateur{
	public CouleurDecorateurB(IStrategieCouleurs palette) {
		super(palette);
	}
	@Override
	public Color palette(int nbItMax, int nbIterations) {
		Color couleur = palette.palette(nbItMax, nbIterations);
		return new Color(couleur.getRed(),couleur.getGreen(),0);
	}
}
