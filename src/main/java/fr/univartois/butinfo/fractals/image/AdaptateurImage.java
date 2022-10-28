/**
 * Ce fichier fait partie du projet sae-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.fractals.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Le type AdaptateurImage
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class AdaptateurImage implements IFractalImage {
    
    private final BufferedImage image;
    
    public AdaptateurImage(BufferedImage image) {
        this.image = image;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getHeight()
     */
    @Override
    public int getHeight() {
        return image.getHeight();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getWidth()
     */
    @Override
    public int getWidth() {
        return image.getWidth();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#getPixel(int, int)
     */
    @Override
    public Pixel getPixel(int row, int column) {
        return new Pixel(this, row, column);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#setColor(int, int, java.awt.Color)
     */
    @Override
    public void setColor(int row, int column, Color color) {
        image.setRGB(column, row, color.getRGB());
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.fractals.image.IFractalImage#saveAs(java.lang.String)
     */
    @Override
    public void saveAs(String path) throws IOException {
        String[] s = path.split("\\.");
        ImageIO.write(image, s[s.length-1], new File(path));
    }

}

