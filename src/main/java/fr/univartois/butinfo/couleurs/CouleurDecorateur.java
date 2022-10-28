package fr.univartois.butinfo.couleurs;

import java.awt.Color;
/**
 * 
 * @author Elsa
 *La classe CouleurDécorateur permet de générer un masque sur une palette de couleur (rouge vert ou bleu)
 *C'est un décorateur.
 */
public abstract class CouleurDecorateur implements IStrategieCouleurs{
	 protected IStrategieCouleurs palette;
	 
	public CouleurDecorateur(IStrategieCouleurs palette) {
		this.palette = palette;
	}

	
	

}
