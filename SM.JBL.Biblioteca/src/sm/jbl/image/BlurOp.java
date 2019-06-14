/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;

/**
 *
 * @author JaviBl8
 */
public class BlurOp extends sm.image.BufferedImageOpAdapter{
    
    public BlurOp(){

    }
    /**
     * Función para aplicar el filtro
     * @param src BufferedImagen de source
     * @param dest BufferedImagen de destino
     * @return BufferedImage con el filtro aplicado(src)
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                Color color = new Color(src.getRGB(x, y));
                int blurR = (int) min(255 , 0.0*color.getRed() + 0.2*color.getGreen() + 0.0*color.getBlue());
                int blurG = (int) min(255, 0.2*color.getRed() + 0.2*color.getGreen() + 0.2*color.getBlue());
                int blurB = (int) min(255, 0.0*color.getRed() + 0.2*color.getGreen() + 0.0*color.getBlue());

                Color blur = new Color(blurR, blurG, blurB);
                src.setRGB(x, y, blur.getRGB());
            }
        }
        return dest;
    }

}
