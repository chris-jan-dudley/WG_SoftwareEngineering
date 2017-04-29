package tradingsimulation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class EventViewer {    
    ViewController controller;
    
    ScrollPane scrollablePane;
    VBox eventStack;
    
    public EventViewer (ViewController controller) {
        this.controller = controller;
        
        eventStack = new VBox(6);
        scrollablePane = new ScrollPane(eventStack);
                
        scrollablePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollablePane.setMinWidth(680);
        scrollablePane.setMaxWidth(680);        
        scrollablePane.setMinHeight(150);
        scrollablePane.setMaxHeight(150);
        scrollablePane.setPadding(new Insets(10));        
    }   
    
    public Node getFxNode() {
        return scrollablePane;        
    }
    
    public void logEvent (String date, String nature, String action) {
        eventStack.getChildren().add(
                new Label(date + ": " + nature + ", " + action)
        );
    }   
}