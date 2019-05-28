/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.herramientas;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 *
 * @author JaviBl8
 */
public class Propiedades {
     
    private boolean relleno;
    private boolean alisado;
    private Color color;
    private Stroke stroke;
    private boolean transparencia;
    AlphaComposite composite = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    public boolean figuraSeleccionada=false;
    
    public Propiedades(){
        relleno = false;
        alisado = false;
        color=Color.BLACK;
        stroke=new BasicStroke(1);
        transparencia = false;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color=color;
    }
    
    public boolean isSelected(){
        return figuraSeleccionada;
    }
    
    public void setSelected(boolean seleccionada){
        this.figuraSeleccionada=seleccionada;
    }

    public boolean getRelleno(){
        return relleno;
    }
    
    public void setRelleno(boolean relleno){
        this.relleno=relleno;        
    }
    
    public boolean getAlisado(){
        return alisado;
    }
    
    public void setAlisado(boolean alisado){
        this.alisado=alisado;        
    }

    public boolean getTransparencia(){
        return transparencia;
    }
    
    public void setTransparente(boolean transparente){
        this.transparencia=transparente;
        
    }

    public Stroke getStroke() {
        return stroke;
    }
    
    public void setStroke(Stroke stroke){
        this.stroke=stroke;
    }

}
 