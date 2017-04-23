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
import javafx.scene.layout.VBox;

/**
 *
 * @author James
 */
public class EventViewer {    
    
    VBox container = new VBox(6);
    
    public EventViewer () {        
        ScrollPane scrollableLog = new ScrollPane(container);
        
        
        scrollableLog.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollableLog.setMaxWidth(670);
        scrollableLog.setPrefHeight(125);
        scrollableLog.setPadding(new Insets(10, 5, 10, 10));        
    }   
    
    public Node getFxNode() {
        return container;        
    }
    
    public void logEvent (String date, String nature, String action) {
        container.getChildren().add(
                new Label(date + ": " + nature + ", " + action)
        );
    }
    
    
    
    
}
