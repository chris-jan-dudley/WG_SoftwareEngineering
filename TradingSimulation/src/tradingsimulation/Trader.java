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
 import java.util.ArrayList;

public abstract class Trader {
    private ArrayList<Client> clients = new ArrayList<>();
    
    abstract void buy (Portfolio portfolio, Company company, int amount);
    
    abstract void sell (Portfolio portfolio, Company company, int amount);
    
    
}
