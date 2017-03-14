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
public class StockExchange extends Market {
    public StockExchange(String name) {
        super(name);
    }
    @Override
    boolean constructFromCSV(String csvStockDataFN, String csvExternalEventsFN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
