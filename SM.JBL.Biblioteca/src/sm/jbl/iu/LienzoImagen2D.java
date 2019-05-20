/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

/**
 *
 * @author JaviBl8
 */
public class LienzoImagen2D extends Lienzo2D {
    
    private BufferedImage img;
    private boolean fondo=true;
    private String extension="PNG";
    private int rgbValue;
    
    public int getRGBValue(){
        return rgbValue;
    }    
    
    public void setImage(BufferedImage img){
        this.img = img;
        if(img!=null) {
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
            //Clip de la imagen
            setClip(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
        }       
    }
    
    public void setFondo(boolean fondo){
        this.fondo=fondo;
    }
    
    public BufferedImage getImage(){
        return img;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(img!=null) g.drawImage(img,0,0,this);
        drawMarco(g);
        
    }
    
    /**
     * Creates new form LienzoImagen2D
     */
    public LienzoImagen2D() {
        initComponents();
        //setRecortar();
    }
    
    public LienzoImagen2D getLienzoImagen2D(){
        return this;
    }
    
    public BufferedImage getImage(boolean drawVector){
        
        if (drawVector) {
            BufferedImage aux = new BufferedImage(img.getWidth(),img.getHeight(),img.getType());
            paint(aux.createGraphics());
            return aux;
        }
        else{
            return img;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
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

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        //dentro = true;
    }//GEN-LAST:event_formMouseEntered

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
       /*
        Point p = evt.getPoint();
        if(dentro){
            rgbValue = img.getRGB(p.x, p.y);
        }   */     
    }//GEN-LAST:event_formMouseMoved

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        //dentro = false;
    }//GEN-LAST:event_formMouseExited

    private void drawMarco(Graphics g) {
        //Stroke stk = ((Graphics2D)g).getStroke();
//        Stroke stk = new BasicStroke(2.5f,CAP_ROUND,JOIN_ROUND);
//        ((Graphics2D)g).setStroke(stk);
//        ((Graphics2D)g).draw(new Rectangle(0,0,img.getWidth(),img.getHeight()));
    Graphics2D g2d = (Graphics2D)g;
    if(fondo){
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 300, 300);   
    }
    Stroke sk = g2d.getStroke();
    float[] discontinuo = { 4.0F, 2.0F };
    Stroke marco = new BasicStroke(3.0F, 1, 1, 1.0F, discontinuo, 0.0F);
    g2d.setStroke(marco);
    g2d.draw(clip);
    g2d.setStroke(sk);
    }

    public void setExtension(String ext){
       this.extension=ext;
    }

    public String getExtension(){
        return extension;
    }

    public BufferedImage convertImageType(int type){
        if(img==null) return null;
        BufferedImage imOut = new BufferedImage(img.getWidth(),
        img.getHeight(), type);
        Graphics2D g2d = imOut.createGraphics();
        g2d.drawImage(img,0,0,null);
        img=imOut;
        return imOut;
    }    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
