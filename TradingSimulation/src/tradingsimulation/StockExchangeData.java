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
class StockExchangeData {
    ArrayList<TickRow> rows;
    
    TickRow addTickRow() {
        TickRow r = new TickRow();
        rows.add(r);
        return(r);
    }
    
    TickRow getTickRow(int atTick) {
        return rows.get(atTick);
    }
    
    TickRow getLatestRow() {
        return rows.get(rows.size()-1);
    }
    
}
