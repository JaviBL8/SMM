/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.eventos;

/**
 *
 * @author JaviBl8
 */
public class MiManejadorLienzo extends LienzoAdapter{
    @Override
    public void shapeAdded(LienzoEvent evt){
        System.out.println("Figura "+evt.getForma()+" añadida");
    }
}
