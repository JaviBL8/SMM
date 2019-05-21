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
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import static sm.jbl.graficos.Figura.composite;
import static sm.jbl.graficos.Figura.render;
import sm.jbl.herramientas.Propiedades;

/**
 *
 * @author JaviBl8
 */
public class Curva1 extends QuadCurve2D.Double implements Figura{
    Propiedades p;
    private AlphaComposite comp;
    private RenderingHints rend;

    /**
     *
     * @param x1
     * @param y2
     * @param x1
     * @param y2
     */
    public Curva1(double x1, double y1, double x2, double y2, double ctrl1, double ctrl2) {
        super(x1,y1,x2,y2,ctrl1,ctrl2);
        this.p = new Propiedades();
        comp = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
        rend = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    }
        
    @Override
    public Color getColor(){
        return this.p.getColor();
    }
    
    @Override
    public void setColor(Color color){
        if(color == null){
            this.p.setColor(Color.BLACK);
        }else{
          this.p.setColor(color);  
        }
    }

    @Override
    public boolean getRelleno(){
        return p.getRelleno();
    }
    
    @Override
    public void setRelleno(boolean relleno){
        this.p.setRelleno(relleno);
    }
    
    @Override
    public boolean getAlisado(){
        return this.p.getAlisado();
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
    public void setStroke(int stroke){
        this.p.setStroke(new BasicStroke(stroke));
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.setStroke(getStroke());
        g2d.setRenderingHints(rend);
        g2d.setComposite(comp);
        if(getRelleno())    g2d.fill(this);
        //Lo mismo para el resto
        g2d.draw(this);
    }
}
