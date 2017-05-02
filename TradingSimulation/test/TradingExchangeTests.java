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
public class TradingExchangeTests {
    
    public TradingExchangeTests() {
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
    public void canAddMarket() {
        TradingExchange TE = new TradingExchange();
        assertTrue(TE.addMarket(new StockExchange("FTSE 100")));
    }
    
    @Test
    public void canUseConfigForCoursework() {
        TradingExchange TE = new TradingExchange(1, "someString.csv", "someMoreString.csv");
    }
    
    // Here for the sake of future expansion potential.
    @Test
    public void canAddMultipleMarket() {
        TradingExchange TE = new TradingExchange();
        TE.addMarket(new StockExchange("FTSE 100"));
        TE.addMarket(new StockExchange("FTSE 200"));
        TE.addMarket(new StockExchange("FTSE 300"));
        TE.getMarket(2);
    }
    
    @Test
    public void canOnlyAccessExistingMarket() {
        boolean thrown = false;
        try {
        TradingExchange TE = new TradingExchange();
        TE.addMarket(new StockExchange("FTSE 100"));
        TE.getMarket(2);
        } catch (IndexOutOfBoundsException e) {
        thrown = true;
        }
            assertTrue(thrown);
    }
    
}
