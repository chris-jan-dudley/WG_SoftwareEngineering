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
public abstract class Company {
    private int sharePrice;
    private int numberOfShares;    
    protected RiskLevels riskFactor;
    
    public enum RiskLevels {
        High, Medium, Low
    }
    
    public Company (int startingShares, int startingPrice) {
        numberOfShares = startingShares;
        sharePrice = startingPrice;
    }   
    
    public boolean setSharesPrice (int newPrice) {
        if (newPrice >= 0) {
            sharePrice = newPrice;
            return true;
        } else {
           return false; 
        }
    }
    
    public int getSharePrice () {
        return sharePrice;
    }
    
    public boolean setNumberOfShares (int newAmount) {
        if (newAmount >= 0) {
            numberOfShares = newAmount;
            return true;
        } else {
           return false; 
        }
    }   
     
    public int getNumberOfShares () {
        return numberOfShares;
    }
    
    public boolean setRiskFactor (int newRiskLevel) {
        switch (newRiskLevel) {
            case 0:
                riskFactor = RiskLevels.Low;
                break;
            case 1:
                riskFactor = RiskLevels.Medium;
                break;
            case 2:
                riskFactor = RiskLevels.High;
                break;
            default:
                return false;

        }
        
        return true;
        
    }   
    
}
