/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author sjb56
 */
public class StockExchange extends Market {

private int currentTick;
private Date startDate;
private Date endDate;
private StockExchangeData mem;
private ArrayList<ExternalEvent> externalEvents;
private HashMap<Integer, ArrayList<ExternalEvent>> externalEventsIndexedToTicks;
private ArrayList<Trader> traders;


    /**
     * Just like with Market/TradingExchange, this is provided for testing, not intended for production use
     * (You should always use constructors with init data rather then manually access methods to add CSV data)
     * 
     * @param marketName - identify the name to use for this market for references.
     */
    public StockExchange(String marketName) {
        super(marketName);
    }

    /**
     * Creates an instance of a stock exchange, following TradingSimulations config 1, and so expecting csv file names for
     * stock init data and external events
     * @param marketName - used for referencing.
     * @param csvStockDataFileName - valid filename expected of form ala. coursework spec.
     * @param csvExternalEventsFileName - valid filename expected of form ala. coursework spec.
     */
    public StockExchange(String marketName, String csvStockDataFileName, String csvExternalEventsFileName) {
        super(marketName);
        if (!this.constructFromCSV(csvStockDataFileName, csvExternalEventsFileName)) {
            // throw error to GUI
             throw new UnsupportedOperationException("Attach method to tell user CSV was not able to loaded, through GUI.");
        }
        // initialise memory
        this.mem = new StockExchangeData();
    }
    
    /**
     * A wrapper function to deal with all the CSV parsing functions
     * @param csvStockDataFN
     * @param csvExternalEventsFN
     * @return false if unable to parse data/file/invalid filename, true if successfully parsed.
     */
    @Override
    boolean constructFromCSV(String csvStockDataFN, String csvExternalEventsFN) {
        try {
            this.parseStockDataCSV(csvStockDataFN);
            this.parseExternalEventCSV(csvExternalEventsFN);
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    /**
     * The vital method to the class, this
     * 1. calls the price change formulas,
     * 2. calls .trade() on all traders to allow to place sell/buy offers,
     * 3. checks for occuring external events and incorporates that,
     * 4. runs the sell/buy offers and
     *          4.1 sets the shares owned to the right places,
     *          4.2 sets the cash to the right values
     * 5. adapts random traders to balanced/aggressive/seller based on probability(.possiblyUpdateMode());
     * 
     */
    @Override
    void tick() {
        this.currentTick = this.currentTick+1;
        
        // update mem
        TickRow thisTickMemory = mem.addTickRow();
        thisTickMemory.addCompanyPrices(new ArrayList<Company>());
        // put company prices in the memory
        thisTickMemory.addTraders();
        // put trader states (agressive, balanced, etc) in memory
        thisTickMemory.addOccuredTrades();
        // put the trades that occured this tick to last..
        thisTickMemory.addEventChanges();
        // put the events that began and ended as a Strings under Events
        thisTickMemory.commitRow();
        // lock the row for editing              
    }
    
    public int getTick() {
        return currentTick;
    }
    
    // note: kept public for individually testing CSV loading the events file only
    public boolean parseExternalEventCSV(String fileName) throws FileNotFoundException {
        // 1st, creates a CSV parser with the configs
        //CsvParser parser = new CsvParser(new CsvParserSettings());

        // 2nd, parses all rows from the CSV file into a 2-dimensional array
        //List<String[]> resolvedData = parser.parseAll(new FileReader("/examples/example.csv"));
        String csvFile = "fileName";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println(Arrays.toString(country));

            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    // note: kept public for individually testing CSV loading for init data only.
    public void parseStockDataCSV(String csvStockDataFN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Access this Stock Exchanges mem objects for the rows specified.
     * @param fromTick
     * @param toTick
     * @return 
     */
    @Override
    public HashMap<Integer, HashMap<String, Integer>> getGraphDataOverTime(int fromTick, int toTick) {
        throw new UnsupportedOperationException("Need some sort of way to transmit data to GUI from this function -"
                + "does the Hashmap<int tickIndex, Hashmap<String goodName, int itemValue>> output work for GUI?");
        
    }
    // to return: Hashmap<int tickIndex, Hashmap<String goodName, int itemValue>>

}
