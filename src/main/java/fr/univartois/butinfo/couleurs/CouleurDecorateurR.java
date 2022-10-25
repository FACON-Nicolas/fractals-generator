package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class CouleurDecorateurR extends CouleurDecorateur{

	public CouleurDecorateurR(IStrategieCouleurs palette) {
		super(palette);
	}
	@Override
	public Color palette(int nbItMax, int nbIterations) {
		Color couleur = palette.palette(nbItMax, nbIterations);
		return new Color(0,couleur.getGreen(),couleur.getBlue());
	}
}
