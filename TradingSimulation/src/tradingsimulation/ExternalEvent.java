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
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sjb56
 */
abstract public class ExternalEvent {

    String nature, action;
    Date date, time;
    boolean isBuy;
    int fromTick, toTick, numDays;

    public ExternalEvent(ArrayList<String> eventsFile) {
        DateFormat df = new SimpleDateFormat("DD/mm/yyyy");
        DateFormat tf = new SimpleDateFormat("hh:mm");

        try {
            date = df.parse(eventsFile.get(0));
            time = tf.parse(eventsFile.get(1));
        } catch (ParseException e) {
        }
        nature = eventsFile.get(2);
        action = eventsFile.get(3);
        isBuy = eventsFile.get(3).contains("buy");

        Pattern pattern = Pattern.compile("\\s(\\d)\\s");
        Matcher matcher = pattern.matcher(eventsFile.get(3));
        if (matcher.find()) {
            numDays = Integer.parseInt(matcher.group().replaceAll(" ", ""));
        }

    }

    public String getNature() {
        return nature;
    }

    public String getAction() {
        return action;
    }

    public int getFromTick() throws ParseException {
        DateFormat df = new SimpleDateFormat("hh:mm");
        Date startDate = df.parse("01/01/2017");
        Date eventDate = date;
        Calendar startCal = Calendar.getInstance();
        Calendar eventCal = Calendar.getInstance();
        startCal.setTime(startDate);
        eventCal.setTime(eventDate);

        int numberOfDays = 1;   //Include start day
        while (startCal.before(eventCal)) {
            if ((Calendar.SATURDAY != startCal.get(Calendar.DAY_OF_WEEK))
                    && (Calendar.SUNDAY != startCal.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
            startCal.add(Calendar.DATE, 1);
        }
        DateFormat tf = new SimpleDateFormat("hh:mm");
        Date startDayTime = tf.parse("09:00");
        Date startEventTime = time;
        long difference = startEventTime.getTime() - startDayTime.getTime();
        long diffMinutes = difference / (60 * 1000) % 60;
        long diffHours = difference / (60 * 60 * 1000) % 24;
        int numberOfTicks = (int) ((numberOfDays * 28) + (diffHours * 4) + (diffMinutes / 15));
        return numberOfTicks;
    }

    public Date getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public int getToTick() {
        return 1;
    }

    int getToTick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
