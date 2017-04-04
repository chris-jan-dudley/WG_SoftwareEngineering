/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author sjb56
 */
public class StockExchange extends Market {

    public StockExchange(String name) {
        super(name);
    }

    @Override
    boolean constructFromCSV(String csvStockDataFN, String csvExternalEventsFN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void parseExternalEventCSV(String fileName) throws FileNotFoundException {
        // 1st, creates a CSV parser with the configs
        //CsvParser parser = new CsvParser(new CsvParserSettings());

        // 2nd, parses all rows from the CSV file into a 2-dimensional array
        //List<String[]> resolvedData = parser.parseAll(new FileReader("/examples/example.csv"));

    }

}
