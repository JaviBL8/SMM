/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import static java.lang.Math.min;
import static sm.jbl.graficos.Figura.composite;
import static sm.jbl.graficos.Figura.render;
import sm.jbl.herramientas.Propiedades;

/**
 *
 * @author JaviBl8
 */
public class RectanguloRedondeado extends RoundRectangle2D.Double implements Figura{
 
    Propiedades p;
    private AlphaComposite comp;
    private RenderingHints rend;

    public RectanguloRedondeado(Point2D p1, Point2D p2) {
        super(p1.getX(),p1.getY(),p2.getX()-p1.getX(),p2.getY()-p1.getY(),10,10);
        this.p = new Propiedades();
        comp = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
        rend = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    @Override
    public Propiedades getPropiedades() {
        return this.p;
    }

    @Override
    public Color getColor(){
        return this.p.getColor();
    }
    
    @Override
    public void setColor(Color color){
        this.p.setColor(color);
    }

    @Override
    public boolean getRelleno(){
        return this.p.getRelleno();
    }
    
    @Override
    public void setRelleno(boolean relleno){
        this.p.setRelleno(relleno);
    }
    
    @Override
    public boolean getAlisado(){
        return p.getAlisado();
    }
    
    @Override
    public void setAlisado(boolean alisado){
        this.rend=render;
        this.p.setAlisado(alisado);
    }

    @Override
    public boolean getTransparencia(){
        return this.p.getTransparencia();
    }
    
    @Override
    public void setTransparente(boolean transparente){
        this.comp=composite;
        this.p.setTransparente(transparente);
    }

    @Override
    public Stroke getStroke() {
        return this.p.getStroke();
    }
    
    @Override
    public void setStroke(int stroke) {
        this.p.setStroke(new BasicStroke(stroke));
    }

    @Override
    public void paint(Graphics2D g2d) {
        
        g2d.setColor(getColor());
        g2d.setStroke(getStroke());
        g2d.setRenderingHints(rend);
        g2d.setComposite(comp);
        if(this.p.figuraSeleccionada){
            g2d.setStroke(stk);
            g2d.draw(this.getBounds2D());
        }
        if(getRelleno())    g2d.fill(this);
        //Lo mismo para el resto
        g2d.draw(this);
    }

    @Override
    public String toString(){
        return "Rectángulo redondeado";
    }
    
    @Override
    public void mover(double x, double y) {
        this.setFrame(min(this.getX(),x),min(this.getY(),y),Math.abs(x-this.getX()),Math.abs(y-this.getY()));
    }

}
