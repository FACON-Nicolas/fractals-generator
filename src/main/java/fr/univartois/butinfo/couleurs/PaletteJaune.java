package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class PaletteJaune implements IStrategieCouleurs{

	@Override
	public Color palette(int nbItMax, int nbIterations) {
		int ratio = nbIterations/nbItMax;
		return new Color(ratio,ratio,ratio/2);
	}

}
