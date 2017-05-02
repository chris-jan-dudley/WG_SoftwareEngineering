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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Conor
 */
public class Portfolio {
    
    private Client ownedBy;
    private Trader managedBy;
    int cashValue = 0;
    Map<Company, Integer> ownedShares;
    int riskValue;
    
    public Portfolio(Client client, Trader trader){
        ownedBy = client;
        managedBy = trader;
        ownedShares = new HashMap<>();
    }
    
    public Client getClient() {
        return this.ownedBy;
    }
    
    public Trader getTrader() {
        return this.managedBy;
    }
    
    public boolean addShares(Company company, int number){
        if(ownedShares.containsKey(company)){
            ownedShares.replace(company, ownedShares.get(company)+(number));
            return true;
        }else if(!ownedShares.containsKey(company)){
            ownedShares.put(company, number);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean removeShares(Company company, int number){
        //remove shares from the map
        if(ownedShares.get(company) <= number){
            ownedShares.replace(company, ownedShares.get(company)-number);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean removeCash(int cash){
        //if cashvalue - cash is >= 0 then
            //cashvalue = cashvalue - cash
            //return true
        //else 
            //return false
            
        if((cashValue - cash) >= 0){
            cashValue -= cash;
            return true;
        } else{
            return false;
        }
    }
    
    public boolean addCash(int cash){
        cashValue += cash;
        return true;
    }
    
    public int getCurrentCash(){
        return cashValue;
    }
    
    public int calculateNetWorth(){
        //go through map
        //for each company in map
        //total value += number of shares of each company
        // * share price of each company
        //return value
        int netWorth = 0;
        for(Company key : ownedShares.keySet()){
            netWorth += ownedShares.get(key);
        }
        return netWorth;
    }
    
    public int getRisk(){
        return riskValue;
    }
    
    public boolean setRisk(int risk){
        if(risk <= 100){
            riskValue = risk;
            return true;
        }
        return false;
    }
    
    
}
