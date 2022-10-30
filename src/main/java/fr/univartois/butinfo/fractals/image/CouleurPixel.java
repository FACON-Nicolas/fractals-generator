package fr.univartois.butinfo.fractals.image;

import fr.univartois.butinfo.couleurs.IStrategieCouleurs;
import fr.univartois.butinfo.fractals.complex.IPlanComplex;
import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.suite.chaotique.IStrategieSuiteChaotique;

import java.util.LinkedList;
import java.util.List;

/**
 * Permet de déterminer la couleur d'un pixel d'une suite chaotique
 */
public class CouleurPixel {

    /**
     * La suite chaotique qui définit les méthodes mathématiques à utiliser pour déterminer la couleur des pixels
     */
    private final IStrategieSuiteChaotique suite;

    /**
     * Calcul le nombre d'iteration
     */
    private int nbIteration;

    /**
     * Le nombre d'iteration maximum
     */
    private final int nbIterationMax;

    /**
     * On garde en mémoire les k derniers termes de la suite
     */
    private final int k;

    /**
     * Valeur entre 0 et 1 qui permet de définir quand une suite converge
     */
    private final float e;

    /**
     * Liste des k derniers termes de la suite
     */
    private final List<IPoint> list;

    /**
     * Plan complexe sur lequel l'image se construit
     */
    private final IPlanComplex planComplex;

    /**
     * Image composée des pixels définis dans cette classe
     */
    private final IFractalImage image;

    /**
     * Palette de couleur utilisée
     */
    private final IStrategieCouleurs palette;

    /**
     * Crée une nouvelle instance de CouleurPixel
     * @param suite La suite chaotique qui définit les calculs mathématiques utilisés
     * @param nbIterationMax Le nombre maximum d'iteration dans cette suite
     * @param planComplex Plan complexe sur lequel on modifie les pixels
     * @param image Image permettant de définir un pixel
     * @param palette Palette de couleur utilisée
     * @param k On garde en mémoire les k derniers termes de la suite
     * @param e Valeur entre 0 et 1 qui permet de définir quand une suite converge
     */
    public CouleurPixel(IStrategieSuiteChaotique suite, int nbIterationMax, IPlanComplex planComplex, IFractalImage image, IStrategieCouleurs palette, int k, float e) {
        if(0 <= e && e <= 1){
            this.suite = suite;
            this.nbIterationMax = nbIterationMax;
            this.k = k;
            this.e = e;
            this.planComplex = planComplex;
            this.image = image;
            this.palette = palette;
            nbIteration = 0;
            list = new LinkedList<>();
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Permet de parcourir les termes de la suite chaotique et d'attribuer la couleur de chaque pixel
     */
    public void parcourir(){
        for (IPoint point : suite) {
            if (!converge() && (nbIteration < nbIterationMax)){
                if (list.size() == k){
                    list.remove(0);
                }
                list.add(point);
                nbIteration++;

            } else {

                Pixel pixel = planComplex.asPixel(point, image);
                if (pixel != null)
                    pixel.setColor(palette.palette(nbIterationMax, nbIteration));
                break;
            }
        }
    }

    /**
     * Permet de savoir si la suite chaotique converge ou non
     * @return vrai ou faux
     */
    private boolean converge() {
        for (int i=1; i< list.toArray().length;i++){
            if (Math.abs((list.get(i-1).getY() - list.get(i).getY())) > e){
                return true;
            }
        }
        return false;
    }


}
