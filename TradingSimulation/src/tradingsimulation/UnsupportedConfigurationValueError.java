/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

/**
 *
 * @author James
 */
public class UnsupportedConfigurationValueError extends RuntimeException {
String err;
    public UnsupportedConfigurationValueError() {
    }
    
    public UnsupportedConfigurationValueError(String s) {
        this.err = s;
    }
    
}
