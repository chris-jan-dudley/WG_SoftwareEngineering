/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author James
 */
public class EventViewer {    
    ScrollPane scrollablePane;
    VBox eventStack;
    
    public EventViewer () {        
        eventStack = new VBox(6);
        scrollablePane = new ScrollPane(eventStack);
                
        scrollablePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollablePane.setMaxWidth(690);
        scrollablePane.setPrefHeight(125);
        scrollablePane.setPadding(new Insets(10, 5, 10, 10));
        
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
