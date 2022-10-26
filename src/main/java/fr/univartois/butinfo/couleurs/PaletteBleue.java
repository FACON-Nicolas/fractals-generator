package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public class PaletteBleue implements IStrategieCouleurs{

	@Override
	public Color palette(int nbItMax, int nbIterations) {
		float ratio =(float) nbIterations/nbItMax;
		return new Color(ratio/2,ratio,ratio);
	}

}
