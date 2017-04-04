/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tradingsimulation.StockExchange;

/**
 *
 * @author Chris
 */
public class EventReadingTests {
    
    StockExchange testSE;
    
    public EventReadingTests() {
    }
    
    @Before
    public void setUp() {
        testSE = new StockExchange("Test Stock Exchange");
  
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void hello() throws FileNotFoundException {
        testSE.parseExternalEventCSV("ExternalEventsData.csv");
    }
}
