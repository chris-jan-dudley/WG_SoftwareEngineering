package tradingsimulation;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SettingsViewer {
    ViewController controller;
    
    VBox container = new VBox(10);
    
    private DatePicker startDate = new DatePicker(LocalDate.of(2017, 1, 1));
    private DatePicker endDate = new DatePicker(LocalDate.of(2018, 1, 1));
    
    public SettingsViewer (ViewController controller) {
        this.controller = controller;
        
        startDate.setMaxWidth(110);
        endDate.setMaxWidth(110);
        
        HBox startWrapper = new HBox(7);
        startWrapper.getChildren().addAll(
                new Label("Start Date: "),
                startDate
        );
        
        HBox endWrapper = new HBox(7);
        endWrapper.getChildren().addAll(
                new Label("End Date: "),
                endDate
        );
        
        Slider speed = new Slider();
        speed.setMaxWidth(120);
       
        HBox controls = new HBox(7);
        controls.getChildren().addAll(
                new Button("▶"),
                new Button("■"),
                speed
        );
        
        container.getChildren().addAll(
                startWrapper,
                endWrapper,
                controls
        );
                
        container.setMinWidth(200);
        container.setMaxWidth(200);
        
        container.setMinHeight(150);
        container.setMaxHeight(150);
        
        container.setPadding(new Insets(10, 7, 10, 7));
               
    }
    
    public Node getFxNode () {
        return container;
    }
    
    public LocalDate getStartDate () {
        return startDate.getValue();
    }
    
    public LocalDate getEndDate () {
        return endDate.getValue();
    }    
}