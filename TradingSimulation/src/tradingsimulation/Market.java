/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.Date;
import java.util.HashMap;

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
private ViewController view;

public Market(String name) {
this.name = name;
}

abstract boolean constructFromCSV(String csvStockDataFN, String csvExternalEventsFN);
abstract void tick();
    /**
     * sets the tick to 0, aka, akin to the start date
     */
    public void resetTick() {
    this.currentTick = 0;
    }




    abstract HashMap<Integer, HashMap<String, Integer>> getGraphDataOverTime(int fromTick, int toTick);

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

