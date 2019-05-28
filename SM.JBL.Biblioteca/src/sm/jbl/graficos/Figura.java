/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import sm.jbl.herramientas.Propiedades;


/**
 *
 * @author JaviBl8
 */
public interface Figura{  
        
    final RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    AlphaComposite composite = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F);
    
    public Color getColor();
    
    public void setColor(Color color);

    public boolean getRelleno();
    
    public void setRelleno(boolean relleno);
    
    public boolean getAlisado();
    
    public void setAlisado(boolean alisado);     

    public boolean getTransparencia();
    
    public void setTransparente(boolean transparente);

    public Stroke getStroke();
    
    public void setStroke(int stroke);
    
    public void paint(Graphics2D g2d);

    public Propiedades getPropiedades();
}
