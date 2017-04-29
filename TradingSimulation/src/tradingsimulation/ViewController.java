package tradingsimulation;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewController extends Application {
    
    BorderPane root = new BorderPane();  
    ChartViewer stocksChart = new ChartViewer();
    EventViewer eventsLog = new EventViewer();
    
    @Override
    public void start(Stage primaryStage) { 
        root.setTop(createMenuBar());
        root.setRight(createFilterTree());
        root.setLeft(stocksChart.getFxNode());
        root.setBottom(eventsLog.getFxNode()); 
        
        eventsLog.logEvent("test", "test", "test");
        
        Scene scene = new Scene(root, 880, 550);        
        primaryStage.setTitle("Stock Market Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void createInterface(String[] args) {
        launch(args);
    }
    
    public ChartViewer getChartViewer () {
        return stocksChart;
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
    
    private Node createFilterTree () {
        VBox container = new VBox(10);
        Label title = new Label ("Chart filters");
        
        TreeItem<String> rootItem = new TreeItem<> ();
        rootItem.setExpanded(true);
        
        TreeItem clients = new TreeItem<>("Clients");
        TreeItem clients1 = new TreeItem<>("Client Joe");    
        TreeItem clients2 = new TreeItem<>("Client Bob");  
        clients.getChildren().addAll(clients1, clients2);
        clients.setExpanded(true);
        
        TreeItem stocks = new TreeItem<>("Stocks");
        TreeItem hard = new TreeItem<>("Hard commodities"); 
        TreeItem food = new TreeItem<>("Food commodities");
        stocks.getChildren().addAll(hard, food);
        stocks.setExpanded(true);
        
        rootItem.getChildren().addAll(clients, stocks);
                
        TreeView<String> tree = new TreeView<> (rootItem);
        tree.setShowRoot(false); 
        tree.setCellFactory(e -> new CustomCell());
        container.getChildren().addAll(title, tree);
        container.setMaxHeight(400);
        container.setPrefWidth(190);
        return container;
        
    }
       
    class CustomCell extends TreeCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (isEmpty()) {
                setGraphic(null);
                setText(null);
            } else {                
                if (this.getTreeItem().isLeaf()) {
                    HBox cellBox = new HBox(10);
                    CheckBox checkBox = new CheckBox();
                    Label label = new Label(item);
                    
                    label.prefHeightProperty().bind(checkBox.heightProperty());
                    cellBox.getChildren().addAll(checkBox, label);
                    setGraphic(cellBox);
                    
                    setText(null);
                } else {
                    setText(item);
                }
            }
        }
    } 
    
    
    
}

