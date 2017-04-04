/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tradingsimulation.AnyExtEvt;
import tradingsimulation.ExternalEvent;
import tradingsimulation.StockExchange;

/**
 *
 * @author Chris
 */
public class EventReadingTests {

    StockExchange testSE;
    ExternalEvent testEE;

    public EventReadingTests() {
    }

    @Before
    public void setUp() {
        ArrayList<String> initEvent = new ArrayList<>(Arrays.asList("Feb 8 2017", "09:00", "Q1Q tech announce exciting developments in their smartphone range, anticipating a new model in June 2017", "Random traders buy Q1Q stock over 2 days"));
        testSE = new StockExchange("Test Stock Exchange");
        testEE = new AnyExtEvt(initEvent);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws FileNotFoundException {
        System.out.println(testEE.getAction());
        System.out.println(testEE.getFromTick());
        System.out.println(testEE.getNature());
        System.out.println(testEE.getIsBuys());
    }
}
