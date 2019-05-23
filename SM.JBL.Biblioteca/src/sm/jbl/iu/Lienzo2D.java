/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.iu;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.ImageIcon;
import sm.jbl.eventos.LienzoEvent;
import sm.jbl.eventos.LienzoListener;
import sm.jbl.herramientas.Herramientas;
import static sm.jbl.herramientas.Herramientas.*;
import sm.jbl.graficos.*;

/**
 *
 * @author JaviBl8
 */
public class Lienzo2D extends javax.swing.JPanel {

    public Herramientas herramienta = Herramientas.LAPIZ;
    private Point2D punto1;
    private Point2D punto2; 
    private Point2D offSet;
    private Figura figura = null;
    List<Figura> vShape = new ArrayList();
    protected Rectangle clip;    
    private boolean editar=false;
    private boolean rellenar=false;
    private Color color;
    private ImageIcon imgRelleno = new ImageIcon(getClass().getResource("/iconos/rellenar.png"));
    private ImageIcon imgAlisado = new ImageIcon(getClass().getResource("/iconos/alisar.png"));
    private ImageIcon imgTrasnparente = new ImageIcon(getClass().getResource("/iconos/transparencia.png"));
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Cursor cursor;
    private boolean alisar;
    private boolean transparentar;
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

    public boolean getEditar(){
        return editar;
    }
    
    public void setFigura(Figura f){
        this.figura = f;
    }
    
    public void setEditar(boolean editar){
        this.editar=editar;
        this.rellenar=false;
        this.alisar=false;
        this.transparentar=false;
    }
    
    public void setRellenar(boolean rellenar) {
        figura.setRelleno(true);
        figura.setColor(color);
        repaint();
    }
    
    public boolean getRellenar(){
        return rellenar;
    }
    
    public void setTransparentar(boolean transparentar) {
        figura.setTransparente(true);
    }
    
    public boolean getTransparentar(){
        return transparentar;
    }
    
    public boolean getAlisar(){
        return alisar;
    }
    
    public void setAlisar(boolean alisar) {
        figura.setAlisado(true);
    }
    
    
    public void setColor(Color c){
        if(c!=null){
            this.color=c;
            if(figura!=null && editar) figura.setColor(color);
            repaint();
        }        
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
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

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        
        if(rellenar){
            cursor=tk.createCustomCursor(imgRelleno.getImage(), new Point(1,1), "Cursor");
            this.setCursor(cursor);
        }
        else if(alisar){
            cursor=tk.createCustomCursor(imgAlisado.getImage(), new Point(1,1), "Cursor");
            this.setCursor(cursor);
        }
        else if(transparentar){
            cursor=tk.createCustomCursor(imgTrasnparente.getImage(), new Point(1,1), "Cursor");
            this.setCursor(cursor);
        }
        else if(editar){
            Cursor c = new Cursor(Cursor.MOVE_CURSOR);
            this.setCursor(c);
        }
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(c);
    }//GEN-LAST:event_formMouseExited
    
    private Shape getSelectedShape(Point2D p){
        for(Figura s:vShape)
        if(((Shape)s).contains(p)) return (Shape) s;
     return null;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        setAtributos(g2d);
    }
    
    public void setAtributos(Graphics2D g2d){
//        g2d.setColor(Color.BLACK);
//        g2d.setPaint(opciones.color);
//        g2d.setStroke(stroke);
//        if(opciones.transparencia) g2d.setComposite(comp);
//        if(opciones.alisado) g2d.setRenderingHints(render);
//        if(opciones.recortar) g2d.clip(clip);
        for(Figura s:vShape) {
            //g2d.draw((Shape)s);
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
        
    }
    
    public void createShape(){
        //Nueva figura
        figura=null;
        switch(herramienta){
            case LAPIZ:
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
        figura.setColor(color);
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
    
    
//    public Propiedades getPropiedades(Shape s){
//        Propiedades p;
//        if(s instanceof Rectangulo){
//            p = ((Rectangulo)s).getPropiedades();
//        }
//        else if(s instanceof Linea){
//            p = ((Linea)s).getPropiedades();
//        }
//        else if(s instanceof Elipse){
//            p = ((Elipse)s).getPropiedades();
//        }
//        return p;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
