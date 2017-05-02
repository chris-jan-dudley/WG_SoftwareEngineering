/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wolfgekko;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Conor
 */
public class Portfolio {
    
    Client ownedBy;
    Trader managedBy;
    int cashValue = 0;
    Map<Company, Integer> ownedShares;
    int riskValue;
    
    public Portfolio(Client client, Trader trader){
        ownedBy = client;
        managedBy = trader;
        ownedShares = new HashMap<>();
    }
    
    public boolean addShares(Company company, int number){
        //if the company contains x shares then
            //add shares from the company to the map
            //return true
        //else return false
        if(company.currentshares <= number){
            ownedShares.replace(company, ownedShares.get(company)+(number));
            return true;
        }else{
            return false;
        }
    }
    
    public void removeShares(Company company, int number){
        //remove shares from the map
        ownedShares.replace(company, ownedShares.get(company)-number);
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
        return 0;
    }
    
    public boolean setRisk(int risk){
        if(risk <= 100){
            riskValue = risk;
            return true;
        }
        return false;
    }

    private static class Trader {

        public Trader() {
        }
    }
    
    
}
