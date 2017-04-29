package tradingsimulation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FilterTreeViewer {
    ViewController controller;
    VBox container = new VBox(10);
    
    public FilterTreeViewer (ViewController controller) {
        this.controller = controller;
                
        Label title = new Label ("Chart filters");
        
        TreeItem<String> rootItem = new TreeItem<> ();
        rootItem.setExpanded(true);
        
        TreeItem clients = new TreeItem<>("Clients");
        TreeItem clients1 = new TreeItem<>("Client Example");    
        clients.getChildren().addAll(clients1);
        clients.setExpanded(true);
        
        TreeItem companies = new TreeItem<>("Companies");
        TreeItem food = new TreeItem<>("Food Company");
        TreeItem hard = new TreeItem<>("Hard Company");
        companies.getChildren().addAll(food, hard);
        companies.setExpanded(true);
        
        rootItem.getChildren().addAll(clients, companies);
                
        TreeView<String> tree = new TreeView<> (rootItem);
        tree.setShowRoot(false); 
        tree.setCellFactory(e -> new CustomCell());
        
        container.setPadding(new Insets(10, 0, 0, 0));
        container.getChildren().addAll(title, tree);
        
        container.setMinHeight(400);
        container.setMaxHeight(400);
        container.setMinWidth(210);
        container.setMaxWidth(210);
    }
    
    public Node getFxNode () {
        return container;
    }
    
    class CustomCell extends TreeCell<String> {
        TreeItem currItem;
        
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (isEmpty()) {
                setGraphic(null);
                setText(null);
            } else {       
                currItem = this.getTreeItem();
                if (currItem.isLeaf()) {
                    HBox cellBox = new HBox(10);
                    CheckBox checkBox = new CheckBox();
                    checkBox.setSelected(true);
                    checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            String catagory = (String) currItem.getParent().getValue();
                            switch (catagory) {
                                case "Companies":
                                    ChartViewer chart = controller.getChart();
                                    for (ChartEntry entry : chart.getCompanyEntries()) {
                                        if (entry.getSeries().getName().equals(item)) {
                                            if (newValue) {                                                
                                                entry.getSeries().getNode().setStyle("-fx-stroke-width: 3;");  
                                            } else {
                                                entry.getSeries().getNode().setStyle("-fx-stroke-width: 0;");  
                                            }
                                        }
                                    }                                    
                                    break;
                                case "Clients":
                                    
                                    break;
                            }                           
                        }
                    });                   
                    
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