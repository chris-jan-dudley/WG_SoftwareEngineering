package tradingsimulation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewController extends Application {
    
    BorderPane root = new BorderPane();  
    SettingsViewer simSettings = new SettingsViewer(this);
    ChartViewer stocksChart = new ChartViewer(this);
    EventViewer eventsLog = new EventViewer(this);
    FilterTreeViewer filterTree = new FilterTreeViewer(this);
    
    
    @Override
    public void start(Stage primaryStage) { 
        root.setTop(createMenuBar());
        root.setRight(filterTree.getFxNode());
        root.setLeft(stocksChart.getFxNode());
        root.setBottom(new HBox(eventsLog.getFxNode(), simSettings.getFxNode())); 
        
        eventsLog.logEvent("test", "test", "test");       
        
        Scene scene = new Scene(root, 880, 550);        
        primaryStage.setTitle("Stock Market Simulation");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void createInterface(String[] args) {
        launch(args);
    }
    
    private Node createMenuBar () {
        MenuBar menuBar = new MenuBar();
        Menu menuSimu = new Menu("Simulation");
        MenuItem start = new MenuItem("Start");
        menuSimu.getItems().addAll(
                new MenuItem("Start"),
                new MenuItem("Stop"),
                new MenuItem("Reset")
        );
        
        Menu menuTraders = new Menu("Traders");
        menuTraders.getItems().addAll(
                new MenuItem("Add trader"),
                new MenuItem("Remove trader")
        );
        
        Menu menuEvents = new Menu("Events");        
        Menu menuGraph = new Menu("Graph");
        menuGraph.getItems().addAll(
                new CheckMenuItem("Show crashed"),
                new CheckMenuItem("Show grid"),
                new CheckMenuItem("Show history")              
        );        
 
        menuBar.getMenus().addAll(menuSimu, menuTraders, menuEvents, menuGraph);
        return menuBar;
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

