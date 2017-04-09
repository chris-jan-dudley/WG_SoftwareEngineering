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
public class StockExchangeData {
    ArrayList<TickRow> rows;
    
    public TickRow addTickRow() {
        TickRow r = new TickRow();
        rows.add(r);
        return(r);
    }
    
    public TickRow getTickRow(int atTick) {
        return rows.get(atTick);
    }
    
    public TickRow getLatestRow() {
        return rows.get(rows.size()-1);
    }
    
}
