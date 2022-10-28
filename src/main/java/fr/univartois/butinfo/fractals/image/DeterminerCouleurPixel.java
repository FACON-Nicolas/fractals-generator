package fr.univartois.butinfo.fractals.image;

import fr.univartois.butinfo.fractals.complex.IPoint;
import fr.univartois.butinfo.fractals.suite.chaotique.IStrategieSuiteChaotique;

import java.util.LinkedList;
import java.util.List;

public class CouleurPixel {

    private final IStrategieSuiteChaotique suite;

    private int nbIteration;
    private final int nbIterationMax;

    private final int k;

    private final float e;

    private List<IPoint> list;


    public CouleurPixel(IStrategieSuiteChaotique suite, int nbIterationMax, int k, float e) {
        if(0 <= e && e <= 1){
            this.suite = suite;
            this.nbIterationMax = nbIterationMax;
            this.k = k;
            this.e = e;
            nbIteration = 0;
            list = new LinkedList<>();
        }
        else {
            throw new IllegalArgumentException();
        }
    }


}
