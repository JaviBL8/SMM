/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.iu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.*;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.List;
import sm.jbl.eventos.LienzoEvent;
import sm.jbl.eventos.LienzoListener;
import sm.jbl.herramientas.Herramientas;
import static sm.jbl.herramientas.Herramientas.*;
import sm.jbl.graficos.*;

/**
 * Gestión de todas las interacciones producidas sobre el lienzo así como algunas propiedades y eventos.
 * 
 * @author JaviBl8
 */
public class Lienzo2D extends javax.swing.JPanel {
    
    /**
     * Herramienta seleccionada
     */
    public Herramientas herramienta = Herramientas.PUNTO;
    /**
     * Punto origen para el trazado de figuras
     */
    private Point2D punto1;
    /**
     * Punto final para el trazado de figuras
     */
    private Point2D punto2; 
    /**
     * Punto para calcular el desplazamiento que se produce al trasladar figuras
     */
    private Point2D offSet;
    /**
     * Figura en uso en cada instante
     */
    private Figura figura = null;
    /**
     * Lista de figuras pintadas en el lienzo
     */
    List<Figura> vShape = new ArrayList();
    /**
     * Área de dibujo permitida
     */
    protected Rectangle clip;  
    /**
     * Variable para determinar cuando se edita del resto de propiedades
     */
    private boolean editar=false;
    /**
     * Lista de eventos personalizados para la clase lienzo
     */
    ArrayList<LienzoListener> lienzoEventListeners = new ArrayList();
    
    
    /**
     * Creates new form Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
        punto1 = new Point2D.Double();
        punto2 = new Point2D.Double();
        offSet = new Point2D.Double();
    }    

    /**
     * @return Booleano de si se está editando el lienzo o no
     */
    public boolean getEditar(){
        return editar;
    }
    
    public void setEditar(boolean editar){
        this.editar=editar;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       
       punto1=evt.getPoint();
       
        if(editar){
            figura = (Figura) getSelectedShape(punto1);
            if(figura != null){
                double x,y;
                if(figura instanceof Line2D){
                   x = ((Line2D)figura).getX1();
                   y = ((Line2D)figura).getY1();
                }
                else{
                   x = ((Shape)figura).getBounds2D().getX();
                   y = ((Shape)figura).getBounds2D().getY();
                }
                offSet.setLocation(x - punto1.getX(), y - punto1.getY());
            }
        }else{
            createShape();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       
        punto2=evt.getPoint();
       
        if(editar){
            figura = (Figura) getSelectedShape(punto2);
            setPosicion((Shape) figura);  
        }
        else{
            updateShape();   
        } 
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased
    
    private Shape getSelectedShape(Point2D p){
        for(Figura s:vShape)
        if(((Shape)s).contains(p)) return (Shape) s;
     return null;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        for(Figura s:vShape) {
            g2d.clip(clip);
            s.paint(g2d);
        }
    }
    
    public void setHerramienta(Herramientas herramienta){
        this.herramienta = herramienta;
    }
    
    public void setPosicion(Shape figura){
        if(figura instanceof Rectangle){
            ((Rectangle)figura).setFrame(punto2.getX()+offSet.getX(),punto2.getY()+offSet.getY(),
                    ((Rectangle) figura).getWidth(), ((Rectangle) figura).getHeight());
        }
        else if(figura instanceof Ellipse2D){
            ((Ellipse2D)figura).setFrame(punto2.getX()+offSet.getX(),punto2.getY()+offSet.getY(),
                    ((Ellipse2D) figura).getWidth(), ((Ellipse2D) figura).getHeight());
        }
        else if(figura instanceof Linea){
            ((Linea)figura).setLocation(new Point2D.Double(punto2.getX()+offSet.getX(),
                                        punto2.getY()+offSet.getY()));
        }
        else if(figura instanceof RectanguloRedondeado){
            ((RectanguloRedondeado)figura).setFrame(punto2.getX()+offSet.getX(),punto2.getY()+offSet.getY(),
                    ((RectanguloRedondeado) figura).getWidth(), ((RectanguloRedondeado) figura).getHeight());
        }
        else if(figura instanceof Arco){
            ((Arco)figura).setFrame(punto2.getX()+offSet.getX(),punto2.getY()+offSet.getY(),
                    ((Arco) figura).getWidth(), ((Arco) figura).getHeight());
        }
        notifyPropertyChangeEvent( new LienzoEvent(this,(Shape)figura));
        
    }
    
    public void createShape(){
        //Nueva figura
        figura=null;
        switch(herramienta){
            case PUNTO:
                figura = new Linea(punto1,punto1);
                break;
            case RECTANGULO:
                figura = new Rectangulo((Point) punto1);
                break;
            case LINEA:
                figura = new Linea(punto1,punto2);
                break;
            case CIRCULO:
                figura = new Elipse(min(punto1.getX(),punto2.getX()),min(punto1.getY(),punto2.getY()),
                        Math.abs(punto2.getX()-punto1.getX()),Math.abs(punto2.getY()-punto1.getY()));
                break;
            case RECTANGULO_REDONDEADO:
                figura = new RectanguloRedondeado(punto1, punto2);
                break;
            case ARCO:
                figura = new Arco(min(punto1.getX(),punto2.getX()),min(punto1.getY(),punto2.getY()),
                        Math.abs(punto2.getX()-punto1.getX()),Math.abs(punto2.getY()-punto1.getY()));
                break;
        
            //Añadir figura al combobox    
        }  
        vShape.add(figura);
        notifyShapeAddedEvent( new LienzoEvent(this,(Shape)figura));
    }
    
    public void updateShape(){
        
        switch(herramienta){
            case RECTANGULO:
                ((Rectangle) vShape.get(vShape.size()-1)).setFrameFromDiagonal(punto1, punto2);
                break;
            case LINEA:
                ((Line2D) vShape.get(vShape.size()-1)).setLine(punto1, punto2);
                break;
            case CIRCULO:
                ((Ellipse2D) vShape.get(vShape.size()-1)).setFrameFromDiagonal(punto1, punto2);
                break;
            case RECTANGULO_REDONDEADO:
                ((RoundRectangle2D) vShape.get(vShape.size()-1)).setFrameFromDiagonal(punto1, punto2);
                break;
            case ARCO:
                ((Arc2D) vShape.get(vShape.size()-1)).setFrameFromDiagonal(punto1, punto2);
                break;
        }
    }
    
    public void setClip(Rectangle clip){
        this.clip=clip;
    }
    
    public Figura getFigura(){
        return figura;
    }
    
    public Herramientas getHerramienta(){
        return herramienta;
    }
    
    public List<Figura> getListaFiguras(){
        return this.vShape;
    }
    
    public void addLienzoListener(LienzoListener listener){
        if (listener != null) {
            lienzoEventListeners.add(listener);
        }
    }
    
    private void notifyShapeAddedEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.shapeAdded(evt);
            }
        }
    }
    private void notifyPropertyChangeEvent(LienzoEvent evt) {
        if (!lienzoEventListeners.isEmpty()) {
            for (LienzoListener listener : lienzoEventListeners) {
                listener.propertyChange(evt);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
