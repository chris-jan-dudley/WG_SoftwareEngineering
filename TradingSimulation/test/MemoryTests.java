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
import tradingsimulation.StockExchangeData;
import tradingsimulation.TickRow;

/**
 *
 * @author sjb56
 */
public class MemoryTests {
    StockExchangeData m;
    public MemoryTests() {
        m = new StockExchangeData();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         m = new StockExchangeData();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void canAddRow() {
       TickRow aTick = m.addTickRow();
    }
    
    @Test
    public void canAddRowAndGetData() {
        TickRow a = m.addTickRow();
        TickRow b = m.addTickRow();
        a.addCompanyPrices(companyObjects);
        a.getCompanyPrices();
        
    }
}
