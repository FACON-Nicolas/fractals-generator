package fr.univartois.butinfo.couleurs;

import java.awt.Color;

public abstract class CouleurDecorateur implements IStrategieCouleurs{
	 protected IStrategieCouleurs palette;
	 
	public CouleurDecorateur(IStrategieCouleurs palette) {
		this.palette = palette;
	}

	
	

}
