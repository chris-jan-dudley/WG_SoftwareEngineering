/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.ArrayList;

/**
 *
 * @author sjb56
 */
public class TickRow {
    ArrayList<Company> companyClonesAtTick;
    public void addCompanyPrices(ArrayList<Company> c) {
        this.companyClonesAtTick = c;
    }
    
    public ArrayList<Company> getCompanyPrices() {
        return this.companyClonesAtTick;
    }

    public void addOccuredTrades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addEventChanges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addTraders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void commitRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
