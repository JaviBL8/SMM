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
 * Clase para tener las propiedades de cada figura
 * @author JaviBl8
 */
public class Propiedades {
    /**
     * Activa o desactiva el relleno de una figura
     */
    private boolean relleno;
    /**
     * Activa o desactiva el alisado de una figura
     */
    private boolean alisado;
    /**
     * Activa o desactiva el alisado de una figura
     */
    private boolean transparencia;
    /**
     * Color para el relleno figura
     */
    private Color color;
    /**
     * Trazo de la figura
     */
    private Stroke stroke;
    /**
     * Componente para la transpacencia
     */
    AlphaComposite composite = java.awt.AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F);
    /**
     * Determina si una figura está seleccionada 
     */
    public boolean figuraSeleccionada=false;
    
    /**
     * Constructor propiedades
     */
    public Propiedades(){
        relleno = false;
        alisado = false;
        color=Color.BLACK;
        stroke=new BasicStroke(1);
        transparencia = false;
    }
    
    /**
     * Devuelve el color de la figura
     * @return Color de la figura
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Establece el color para la figura
     * @param color Color que va a tener la figura
     */
    public void setColor(Color color){
        this.color=color;
    }
    
    /**
     * Devuelve si la figura está seleccionada o no
     * @return 1 si la figura está seleccionada, 0 en cualquier otro caso
     */
    public boolean isSelected(){
        return figuraSeleccionada;
    }
    
    /**
     * Establece si la figura está seleccionada o no
     * @param seleccionada Valor que determina si la figura está seleccionada 
     */
    public void setSelected(boolean seleccionada){
        this.figuraSeleccionada=seleccionada;
    }

    /**
     * Devuelve si la figura tiene relleno o no
     * @return Boolean 1 si tiene transparencia, 0 en otro caso
     */
    public boolean getRelleno(){
        return relleno;
    }
    
    /**
     * Establece si la figura tiene relleno
     * @param relleno 1 activa el relleno, 0 desactiva
     */
    public void setRelleno(boolean relleno){
        this.relleno=relleno;        
    }
    
    /**
     * Devuelve si la figura tiene alisado o no
     * @return 1 si la figura está alisada, 0 en otro caso
     */
    public boolean getAlisado(){
        return alisado;
    }
    
    /**
     * Establece si la figura está alisada
     * @param alisado 1 activa el alisado, 0 desactiva
     */
    public void setAlisado(boolean alisado){
        this.alisado=alisado;        
    }

    /**
     * Devuelve si la figura es transparente o no
     * @return 1 si la figura es transparente, 0 en otro caso
     */
    public boolean getTransparencia(){
        return transparencia;
    }
    
    /**
     * Establece si la figura es transparente
     * @param transparente 1 activa la transparencia, 0 desactiva
     */
    public void setTransparente(boolean transparente){
        this.transparencia=transparente;
    }
    
    /**
     * Devuelve el trazo del borde
     * @return El trazo del borde 
     */ 
    public Stroke getStroke() {
        return stroke;
    }
    
    /**
     * Establece el trazo del borde
     * @param stroke Trazo que aplica
     */
    public void setStroke(Stroke stroke){
        this.stroke=stroke;
    }

}
 