package tradingsimulation;

import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        startDate.valueProperty().addListener((ov, oldValue, newValue) -> {            
            if (newValue.compareTo(endDate.getValue()) > 0) {
                startDate.setValue(endDate.getValue());
            } 
            controller.getChart().updateDateBounds();
        });  
        
        endDate.setMaxWidth(110);
        endDate.valueProperty().addListener((ov, oldValue, newValue) -> {            
            if (newValue.compareTo(startDate.getValue()) < 0) {
                endDate.setValue(startDate.getValue());
            }  
            controller.getChart().updateDateBounds();
        });
        
        
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
        speed.setMin(0);
        speed.setValue(1);
        speed.setMax(100);        
        speed.setShowTickMarks(true);
        speed.setShowTickLabels(true);
        
        Button playPauseBut = new Button("▶");
        playPauseBut.setOnAction(e -> {
                if (playPauseBut.getText().equals("▶")) {
                    playPauseBut.setText("||");
                } else {
                    playPauseBut.setText("▶");
                }  
        });
        
        Button stopBut = new Button("■");
        stopBut.setOnAction(e -> 
                controller.reset()
        );
        
        HBox controls = new HBox(7);
        controls.getChildren().addAll(
                playPauseBut,
                stopBut,
                speed
        );
        
        container.getChildren().addAll(
                startWrapper,
                endWrapper,
                controls
        );
                
        container.setMinWidth(200);      
        container.setMinHeight(150);       
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