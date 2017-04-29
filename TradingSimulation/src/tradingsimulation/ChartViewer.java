/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author James
 */
public class ChartViewer {
    VBox container = new VBox();
    LineChart<Number,Number> lineChart;
    
    NumberAxis dateAxis = new NumberAxis();
    NumberAxis netWorthAxis = new NumberAxis();
    
    DatePicker fromDatePicker = new DatePicker(LocalDate.of(2017, 1, 1));
    DatePicker toDatePicker = new DatePicker(LocalDate.of(2017, 12, 31));
    
    ArrayList<ChartEntry> companyEntries = new ArrayList<>();
    ArrayList<ChartEntry> clientEntries = new ArrayList<>();
    ArrayList<ChartEntry> traderEntries = new ArrayList<>();
    
    public ChartViewer () {
        dateAxis.setLabel("Days Since Simulation Start"); 
        dateAxis.setAutoRanging(false);
        dateAxis.setTickUnit(50);
        
        updateDateAxis();
        fromDatePicker.setOnAction(e -> updateDateAxis());    
        toDatePicker.setOnAction(e -> updateDateAxis());
        
        netWorthAxis.setLabel("Net Worth in Pence");
        
        lineChart = new LineChart<>(dateAxis, netWorthAxis);                
        lineChart.setTitle("Stock Monitoring");
         
        lineChart.setMaxHeight(360);
        lineChart.setPrefWidth(630);
        lineChart.setLegendVisible(false);
        
        HBox tools = new HBox(7);        
        
        tools.getChildren().addAll(
                new Label("From: "),
                fromDatePicker,
                new Label("To: "),
                toDatePicker,
                new Button("Play"),
                new Button("Pause"),
                new Slider()
        );
               
        tools.setPadding(new Insets(0, 0, 0, 8));
                
        container.getChildren().addAll(lineChart, tools);
        
    }    
    
    public Node getFxNode () {
        return container;         
    }
    
    private void updateDateAxis () {
        dateAxis.setLowerBound(0);
        dateAxis.setUpperBound((int) ChronoUnit.DAYS.between(fromDatePicker.getValue(), toDatePicker.getValue()));        
    }
    
    public void AddCompanyToChart (Company company) {
        XYChart.Series companyData = new XYChart.Series();
        companyData.setName(company.getName());
        companyData.getData().add(new XYChart.Data(company.getNumberOfShares() * company.getSharePrice(), 0));     
        lineChart.getData().add(companyData);  
        companyEntries.add(new ChartEntry(company, companyData));
    }
    
    public void AddClientToChart (Client client) {
        XYChart.Series clientData = new XYChart.Series();
        clientData.setName(client.getName());
        clientData.getData().add(new XYChart.Data(client.getNetWorth(), 0));     
        lineChart.getData().add(clientData);  
        clientEntries.add(new ChartEntry(client, clientData));
    }
    
    public void UpdateAllSeries () {
        double days = StockExchange.getTick() / 28;
        for (ChartEntry entry : companyEntries) {            
            Company comp = (Company) entry.getObject();
            entry.getSeries().getData().add(new XYChart.Data(comp.getNumberOfShares() * comp.getSharePrice(), days));            
        }
        
        for (ChartEntry entry : clientEntries) {
            Client client = (Client) entry.getObject();
            entry.getSeries().getData().add(new XYChart.Data(client.getNetWorth(), days));            
        }
        
    }
    
    
    
}
