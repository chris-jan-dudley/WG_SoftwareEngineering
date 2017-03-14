/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.Date;

/**
 *
 * @author sjb56
 */
abstract public class Market {
private final String name;
private int currentTick;
private Date startDate;
private Date endDate;
private int tickRate;

public Market(String name) {
this.name = name;
}

abstract boolean constructFromCSV(String csvStockDataFN, String csvExternalEventsFN);
abstract void tick();

public void resetTick() {
this.currentTick = 0;
}




// getGraphDataOverTime(int fromTick, int toTick):
//Hashmap<int tickIndex, Hashmap<String goodName, int itemValue>>

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
    * param tick, an int referencing the tick
    *
    *
     * @param tick
    */
    public Date getDateFromTick(int tick) {
    return new Date(0,0,0);
    }  

}

