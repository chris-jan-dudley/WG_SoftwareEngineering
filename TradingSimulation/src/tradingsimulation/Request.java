/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Conor
 */
class Request {
    
    HashMap<Company, Integer> wantToBuy;
    Portfolio portfolio;
    
    
    public Request(Portfolio port){
        portfolio = port;
        wantToBuy = new HashMap<>();
    }
    
    public Portfolio getPortfolio(){
        return portfolio;
    }
    
    public void setPortfolio(Portfolio portf){
        portfolio = portf;
    }
    
    public HashMap<Company, Integer> getMap(){
        return wantToBuy;
    }
    
    void setMap(HashMap<Company, Integer> map){
        wantToBuy = map;
    }
    
}
