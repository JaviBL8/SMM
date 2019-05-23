/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.eventos;

import java.awt.Color;
import java.awt.Shape;
import java.util.EventObject;

public class LienzoEvent extends EventObject{
    private Shape forma;
    
    public LienzoEvent(Object source, Shape forma) {
        super(source);
        this.forma = forma;
    }
    public Shape getForma() {
        return forma;
    }
    
}
