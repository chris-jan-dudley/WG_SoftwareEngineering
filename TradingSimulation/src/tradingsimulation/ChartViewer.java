package tradingsimulation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChartViewer {
    private ViewController controller;
    
    private VBox container = new VBox();
    private LineChart<Number,Number> lineChart;
    
    private NumberAxis dateAxis = new NumberAxis();
    private NumberAxis netWorthAxis = new NumberAxis();
    
    private DatePicker viewFromDate = new DatePicker(LocalDate.of(2017, 1, 1));
    private DatePicker viewToDate = new DatePicker(LocalDate.of(2018, 1, 1));
    
    private ArrayList<ChartEntry> companyEntries = new ArrayList<>();
    private ChartEntry indexEntry;
    
    public ChartViewer (ViewController controller, ArrayList<Company> companies) {
        this.controller = controller;
        
        dateAxis.setLabel("Days Since Simulation Start"); 
        dateAxis.setAutoRanging(false);
        dateAxis.setTickUnit(50);
        
        updateDateBounds();
        viewFromDate.setOnAction(e -> {
            updateDateBounds();
            if (viewFromDate.getValue().compareTo(viewToDate.getValue()) > 0) {
                viewFromDate.setValue(viewToDate.getValue());
            }
        });    
        
        viewToDate.setOnAction(e -> {
            updateDateBounds();
            if (viewToDate.getValue().compareTo(viewFromDate.getValue()) < 0) {
                viewToDate.setValue(viewFromDate.getValue());
            }
        });
        
        netWorthAxis.setLabel("Share Price in Pence");
        
        lineChart = new LineChart<>(dateAxis, netWorthAxis);                
        lineChart.setTitle("Stock Monitoring");
         
        lineChart.setMaxHeight(360);
        lineChart.setPrefWidth(680);
        lineChart.setLegendSide(Side.RIGHT);
        lineChart.setCreateSymbols(false);
        
        GenerateTestData();
               
        HBox chartParameters = new HBox(7);  
        chartParameters.setPadding(new Insets(0, 0, 0, 70));
        chartParameters.getChildren().addAll(
                new Label("View From: "),
                viewFromDate,
                new Label("View To: "),
                viewToDate
        );        
                
        container.getChildren().addAll(lineChart, chartParameters);
    }    
    
    public void updateDateBounds () {
        LocalDate startDate = controller.getSettings().getStartDate();
        LocalDate endDate = controller.getSettings().getEndDate();
        if (viewFromDate.getValue().compareTo(startDate) < 0) {
            viewFromDate.setValue(startDate);
        }
        
        if (viewToDate.getValue().compareTo(endDate) > 0) {
            viewToDate.setValue(endDate);
        }
        
        dateAxis.setLowerBound((int) ChronoUnit.DAYS.between(startDate, viewFromDate.getValue()));
        dateAxis.setUpperBound((int) ChronoUnit.DAYS.between(startDate, endDate) - ChronoUnit.DAYS.between(viewToDate.getValue(), endDate));
    }
    
    public Node getFxNode () {
        return container;         
    }
        
    public void addCompaniesToChart (ArrayList<Company> companies) {
        double sumSharePrice = 0;
        for (Company companyObj : companies) {
            XYChart.Series companyData = new XYChart.Series();
            companyData.setName(companyObj.getName());
            companyData.getData().add(new XYChart.Data(0, companyObj.getSharePrice()));     
            lineChart.getData().add(companyData);  
            companyEntries.add(new ChartEntry(companyObj, companyData));
            sumSharePrice += companyObj.getSharePrice();
        }
        
        XYChart.Series indexData = new XYChart.Series();
        indexData.setName("Index");
        indexData.getData().add(new XYChart.Data(0, sumSharePrice / companies.size()));     
        lineChart.getData().add(indexData);  
        indexEntry = new ChartEntry(null, indexData);
        
    }
    
    int tick = 0; //TESTING
    
    public void updateAllSeries () {
        double day = tick / 28;
        double sumSharePrice = 0;
        for (ChartEntry entry : companyEntries) {            
            Company entryComp = (Company) entry.getObject();
            //for (Company modelComp : controller.getExchange().getStockExchangeData().getLatestRow().getCompanyPrices) {
            //    if (modelComp.getName().equals(entryComp.getName())) {
            //        entry.getSeries().getData().add(new XYChart.Data(day, modelComp.getSharePrice()));
            //        sumSharePrice += entryComp.getSharePrice(); 
            //    }                           
            //}
                       
        }          
        indexEntry.getSeries().getData().add(new XYChart.Data(day, sumSharePrice / companyEntries.size()));
        
    }
    
    public ArrayList<ChartEntry> getCompanyEntries () {
        return companyEntries;
    }
    
    public ChartEntry getIndexEntry () {
        return indexEntry;
    }
    
    private void GenerateTestData () {  
        ArrayList<Company> startingCompanies = new ArrayList<>();
        
        Company c1 = new FoodCompany("Food Company", 250, 6);
        Company c2 = new HardCompany("Hard Company", 500, 3);
        Company c3 = new HiTechCompany("Tech Company", 150, 12);
        
        startingCompanies.add(c1);
        startingCompanies.add(c2);
        startingCompanies.add(c3);        
        addCompaniesToChart(startingCompanies);   
        
        c1.setSharePrice(4);
        c2.setSharePrice(15);
        c3.setSharePrice(6.6);
        tick = 50;
        updateAllSeries();
        
        c1.setSharePrice(8);
        c2.setSharePrice(5);
        c3.setSharePrice(17);
        tick = 100;
        updateAllSeries();
        
    }
    
    
}
