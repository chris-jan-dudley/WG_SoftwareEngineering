/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Conor
 */

public abstract class Trader {
    
    
    ArrayList<Client> clients;
    ArrayList<Request> buyRequests;
    ArrayList<Request> sellRequests;
    StockExchange stockE;
    
    public Trader(ArrayList<Client> clients, StockExchange stockE){
        buyRequests = new ArrayList<>();
        sellRequests = new ArrayList<>();
        this.stockE = stockE;
        this.clients = clients;
    }
    
    public void addToMap(HashMap<Company, Integer> map, Company company, int number){
        
        //If the map contains the company with shares already, replace it with
        //new number of shares. otherwise just add to map.
            if(map.containsKey(company)){
                map.replace(company, (number + (map.get(company))));
            } else {
                map.put(company, number);
            }
        
        
    }
    
    //for clearing request lists between ticks
    void clear(){
        buyRequests = new ArrayList<>();
        sellRequests = new ArrayList<>();
    }

    abstract void tradeBuy();
    abstract void tradeSell();
    
    abstract void recalculateStrategy();
    
}
