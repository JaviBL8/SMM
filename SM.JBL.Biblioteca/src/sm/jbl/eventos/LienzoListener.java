/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.eventos;

import java.util.EventListener;

/**
 *
 * @author JaviBl8
 */
public interface LienzoListener extends EventListener{
    public void shapeAdded(LienzoEvent evt);
    public void propertyChange(LienzoEvent evt);
}