/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tradingsimulation.StockExchange;
import tradingsimulation.TradingExchange;

/**
 *
 * @author James
 */
public class StockExchangeTests {
    TradingExchange TE = new TradingExchange();
    public StockExchangeTests() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
     public void canInstantiateConfigStockExchange() {
        assertTrue(TE.addMarket(new StockExchange("FTSE 500", "someText.csv", "ExternalEventsData.csv")));
    }
     
     @Test
     public void canAddCompanies() {
        TE.addMarket(new StockExchange("FTSE 500", "someText.csv", "ExternalEventsData.csv"));
        StockExchange SE = (StockExchange) TE.getMarket(0);
    }
}
