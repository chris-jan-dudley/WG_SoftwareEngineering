/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradingsimulation;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author sjb56
 */
abstract public class ExternalEvent {

    String nature, action;
    Date date, time;
    boolean isBuy;
    int fromTick, toTick;

    public ExternalEvent(ArrayList<String> eventsFile) {
        DateFormat df = new SimpleDateFormat("hh:mm");
        DateFormat tf = new SimpleDateFormat("DD/mm/yyyy");

        try {
            date = df.parse(eventsFile.get(0));
            time = tf.parse(eventsFile.get(1));
        } catch (ParseException e) {
        }
        nature = eventsFile.get(2);
        action = eventsFile.get(3);
        isBuy = eventsFile.get(4).equals("buy");
    }
}
