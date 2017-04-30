package tradingsimulation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewController extends Application {
    
    BorderPane root = new BorderPane();  
    SettingsViewer simSettings = new SettingsViewer(this);
    ChartViewer stocksChart = new ChartViewer(this, null);
    //ChartViewer stocksChart = new ChartViewer(this, exchange.getCompanies());
    FilterTreeViewer filterTree = new FilterTreeViewer(this);
    EventViewer eventsLog = new EventViewer(this, null);
    //EventViewer eventsLog = new EventViewer(this, exchange.getEvents());
        
    /*
    StockExchange exchange;
    
    public StockExchange getExchange () {
        return exchange;
    }    
    */
    
    @Override
    public void start(Stage primaryStage) {
        root.setRight(filterTree.getFxNode());
        root.setLeft(stocksChart.getFxNode());
        root.setBottom(new HBox(eventsLog.getFxNode(), simSettings.getFxNode())); 
        
        eventsLog.logEvent("test", "test", "test");
        eventsLog.logEvent("test", "test", "test");
        eventsLog.logEvent("test", "test", "test");
        eventsLog.logEvent("test", "test", "test");
        
        Scene scene = new Scene(root, 880, 550);        
        primaryStage.setTitle("Stock Market Simulation");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }
    
    public static void readyGUI(String[] args) {
        launch(args);
    }

    /*
    public static void readyGUI(StockExchange exchange) {
        ViewController view = new ViewController(exchange);
        launch();
    }
    */
    
    public void update () {
        stocksChart.updateAllSeries();
    }
    
    public void reset () {
        eventsLog.clearEventsLog();
    }    
    
    public ChartViewer getChart () {
        return stocksChart;
    }
    
    public EventViewer getEventLog () {
        return eventsLog;
    }
    
    public FilterTreeViewer getFilterTree () {
        return filterTree;
    }
    
    public SettingsViewer getSettings () {
        return simSettings;
    }
    
    
    
    
    
    
    
}

