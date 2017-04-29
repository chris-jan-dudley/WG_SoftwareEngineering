package tradingsimulation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class ChartViewer {
    private ViewController controller;
    
    private VBox container = new VBox();
    private LineChart<Number,Number> lineChart;
    
    private NumberAxis dateAxis = new NumberAxis();
    private NumberAxis netWorthAxis = new NumberAxis();
    
    private DatePicker viewFromDate = new DatePicker(LocalDate.of(2017, 1, 1));
    private DatePicker viewToDate = new DatePicker(LocalDate.of(2018, 1, 1));
    
    private ArrayList<ChartEntry> companyEntries = new ArrayList<>();
    private ArrayList<ChartEntry> clientEntries = new ArrayList<>();
    
    public ChartViewer (ViewController controller) {
        this.controller = controller;
        
        dateAxis.setLabel("Days Since Simulation Start"); 
        dateAxis.setAutoRanging(false);
        dateAxis.setTickUnit(50);
        
        updateDateBounds();
        viewFromDate.setOnAction(e -> updateDateBounds());    
        viewToDate.setOnAction(e -> updateDateBounds());
        
        netWorthAxis.setLabel("Net Worth in Pence");
        
        lineChart = new LineChart<>(dateAxis, netWorthAxis);                
        lineChart.setTitle("Stock Monitoring");
         
        lineChart.setMaxHeight(360);
        lineChart.setPrefWidth(680);
        lineChart.setLegendVisible(false);
        lineChart.setCreateSymbols(false);
        
        GenerateTestData();
               
        HBox chartParameters = new HBox(7);  
        chartParameters.setPadding(new Insets(0, 0, 0, 8));
        chartParameters.getChildren().addAll(
                new Label("View From: "),
                viewFromDate,
                new Label("View To: "),
                viewToDate
        );        
                
        container.getChildren().addAll(lineChart, chartParameters);
    }    
    
    private void updateDateBounds () {
        dateAxis.setLowerBound((int) ChronoUnit.DAYS.between(controller.getSettings().getStartDate(), viewFromDate.getValue()));
        dateAxis.setUpperBound((int) ChronoUnit.DAYS.between(controller.getSettings().getStartDate(), controller.getSettings().getEndDate()) - ChronoUnit.DAYS.between(viewToDate.getValue(), controller.getSettings().getEndDate()));
    }
    
    public Node getFxNode () {
        return container;         
    }
        
    public void AddCompanyToChart (Company company) {
        XYChart.Series companyData = new XYChart.Series();
        companyData.setName(company.getName());
        companyData.getData().add(new XYChart.Data(0, company.getNumberOfShares() * company.getSharePrice()));     
        lineChart.getData().add(companyData);  
        companyEntries.add(new ChartEntry(company, companyData));
    }
    
    public void AddClientToChart (Client client) {
        XYChart.Series clientData = new XYChart.Series();
        clientData.setName(client.getName());
        clientData.getData().add(new XYChart.Data(0, client.getNetWorth()));     
        lineChart.getData().add(clientData);  
        clientEntries.add(new ChartEntry(client, clientData));
    }
    
    public void UpdateAllSeries () {
        double days = StockExchange.getTick() / 28;
        for (ChartEntry entry : companyEntries) {            
            Company comp = (Company) entry.getObject();
            entry.getSeries().getData().add(new XYChart.Data(days, comp.getNumberOfShares() * comp.getSharePrice()));            
        }
        
        for (ChartEntry entry : clientEntries) {
            Client client = (Client) entry.getObject();
            entry.getSeries().getData().add(new XYChart.Data(days, client.getNetWorth()));            
        }
        
    }
    
    public ArrayList<ChartEntry> getCompanyEntries () {
        return companyEntries;
    }
    
    public ArrayList<ChartEntry> getClientEntries () {
        return clientEntries;
    }
    
    private void GenerateTestData () {
        Company temp = new FoodCompany("Food Company", 100, 10);
        XYChart.Series companyData = new XYChart.Series();
        companyData.setName("Food Company");
        companyData.getData().add(new XYChart.Data(0, temp.getNumberOfShares() * temp.getSharePrice()));     
        companyData.getData().add(new XYChart.Data(180, 850));
        companyData.getData().add(new XYChart.Data(364, 120));        
        lineChart.getData().add(companyData);  
        companyEntries.add(new ChartEntry(temp, companyData));
        
        Company temp1 = new HardCompany("Hard Company", 500, 10);
        XYChart.Series companyData1 = new XYChart.Series();
        companyData1.setName("Hard Company");
        companyData1.getData().add(new XYChart.Data(0, temp1.getNumberOfShares() * temp1.getSharePrice()));     
        companyData1.getData().add(new XYChart.Data(180, 300));
        companyData1.getData().add(new XYChart.Data(364, 2000));        
        lineChart.getData().add(companyData1);  
        companyEntries.add(new ChartEntry(temp1, companyData1));        
    }
    
    
}
