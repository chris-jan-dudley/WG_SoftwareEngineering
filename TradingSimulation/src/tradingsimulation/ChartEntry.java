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
public class ChartEntry {
    private Object object;
    private XYChart.Series series;    
    
    public ChartEntry (Object _object, XYChart.Series _series) {        
        object = _object;    
        series = _series;
    }
    
    public Object getObject() {
        return object;
    }
    
    public XYChart.Series getSeries () {
        return series;
    }
    
    
    
}
