/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

/**
 *
 * @author sjb56
 */
abstract public class ExternalEvent {
    
    String nature, action;
    boolean isBuy;
    int fromTick, toTick;
    
    public ExternalEvent(){
        
    }
}
