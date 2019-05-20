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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import sm.jbl.herramientas.Propiedades;

/**
 *
 * @author JaviBl8
 */
public class Linea extends Line2D.Double implements Figura{
    
    Propiedades p;
    private AlphaComposite comp;
    private RenderingHints rend;    
    
    @Override
    public Color getColor(){
        return p.getColor();
    }
    
    @Override
    public void setColor(Color color){
        p.setColor(color);
    }

    @Override
    public boolean getRelleno(){
        return p.getRelleno();
    }
    
    @Override
    public void setRelleno(boolean relleno){
        p.setRelleno(relleno);
    }
    
    @Override
    public boolean getAlisado(){
        return p.getAlisado();
    }
    
    @Override
    public void setAlisado(boolean alisado){
        this.rend=render;
        p.setAlisado(alisado);
    }

    @Override
    public boolean getTransparencia(){
        this.comp=composite;
        return p.getTransparencia();
    }
    
    @Override
    public void setTransparente(boolean transparente){
        p.setTransparente(transparente);
    }

    @Override
    public Stroke getStroke() {
        return p.getStroke();
    }
    
    @Override
    public void setStroke(int stroke){
        p.setStroke(new BasicStroke(stroke));
    }
    
    public Linea(Point2D p1, Point2D p2){
        super(p1, p2);
        p = new Propiedades();
        comp = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
        rend = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    }
    
    public boolean isNear(Point2D p){
    if (getP1().equals(getP2())) {
      return getP1().distance(p) <= 2.0D;
    }
    return ptLineDist(p) <= 2.0D;
    }

    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }

    public void setLocation(Point2D pos){
        double dx=pos.getX()-this.getX1();
        double dy=pos.getY()-this.getY1();
        Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
        this.setLine(pos,newp2);
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
