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
 * Interfaz que implementan todas las clases
 * @author JaviBl8
 */
public interface Figura{  
        
    final RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    AlphaComposite composite = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F);
    
    /**
     * Devuelve el color de la figura
     * @return Devuelve el color de la figura
     */
    public Color getColor();
    
    /**
     * Cambia el color de la figura
     * @param color El color que se desee aplicar
     */
    public void setColor(Color color);

    /**
     * Devuelve si la figura está rellena
     * @return Devuelve si la figura está rellena
     */
    public boolean getRelleno();
    
    /**
     * Establece que la figura está rellena
     * @param relleno 1 activa, 0 desactiva
     */
    public void setRelleno(boolean relleno);
    
    /**
     * Devuelve si la figura está alisada
     * @return Devuelve si la figura está alisada
     */
    public boolean getAlisado();
    
    /**
     * Establece que la figura está alisada
     * @param alisado 1 activa, 0 desactiva
     */
    public void setAlisado(boolean alisado);     

    /**
     * Devuelve si una figura es transparente
     * @return Devuelve si la figura tiene transparencia
     */
    public boolean getTransparencia();
    
    /**
     * Establece que la figura va a ser transparente
     * @param transparente 1 activa, 0 desactiva
     */
    public void setTransparente(boolean transparente);

    /**
     * Devuelve el trazo de la figura
     * @return Devuelve el trazo de la fgura
     */
    public Stroke getStroke();
    
    /**
     * Establece el tipo de trazo que tendrá el borde de la figura
     * @param stroke Trazo de la figura
     */
    public void setStroke(int stroke);
    
    public void paint(Graphics2D g2d);
    
    /**
     * Devuelve las propiedades de la figura
     * @return Devuelve las propiedades de la figura
     */
    public Propiedades getPropiedades();

    /**
     * Mueve la figura
     * @param x Punto x 
     * @param y Punto y
     */
    public void mover(double x, double y);
}
