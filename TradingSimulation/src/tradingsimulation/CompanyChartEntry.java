/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import javafx.scene.chart.XYChart;

/**
 *
 * @author James
 */
public class CompanyChartEntry {
    private Company company;
    private XYChart.Series data;    
    
    public CompanyChartEntry (Company _company, XYChart.Series _data) {        
        company = _company;    
        data = _data;
    }
    
    public Company getCompany() {
        return company;
    }
    
    public XYChart.Series getData () {
        return data;
    }
    
    
    
}
