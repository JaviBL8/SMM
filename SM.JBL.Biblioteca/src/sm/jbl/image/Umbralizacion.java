/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.image;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author JaviBl8
 */
public class Umbralizacion extends sm.image.BufferedImageOpAdapter{

    private int umbral;
    
    public Umbralizacion(int umbral){
        this.umbral=umbral;
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
                int colorMedio = (color.getRed() + color.getGreen() + color.getBlue())/3;
                
                if (colorMedio >= umbral)
                    dest.setRGB(x, y, Color.WHITE.getRGB());
                else
                    dest.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
        return dest;
    }

    
}
