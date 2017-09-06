package com.greensnow25;

import com.greensnow25.Database.DBOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * Public class MyTaskTimer.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.08.2017.
 */
public class MyTaskTimer extends TimerTask {
    /**
     * task
     */
    private final HTMLParserExample scheduler;
    /**
     * hour, when starts running.
     */
    private final int hourOfDay;
    /**
     * minute when, starts running.
     */
    private final int minute;
    /**
     * second ,when starts running.
     */
    private final int second;

    /**
     * logger
     */
    private Logger l = LoggerFactory.getLogger(getClass());

    /**
     * constructor.
     *
     * @param hourOfDay hour, when starts running.
     * @param minute    minute when, starts running.
     * @param second    second ,when starts running.
     * @throws SQLException ex.
     */
    public MyTaskTimer(int hourOfDay, int minute, int second) throws SQLException {
        this.scheduler = new HTMLParserExample(new DBOperations());
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
    }

    /**
     * run task, in background .
     */
    @Override
    public void run() {
        try {
            scheduler.parsePages();
        } catch (ParseException e) {
            l.warn(e.getMessage(), e);
        } catch (SQLException e) {
            l.warn(e.getMessage(), e);
        }
    }

    /**
     * get date of the start.
     *
     * @return date.
     */
    private Date getDateOfStart() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR, this.hourOfDay);
        date.set(Calendar.MINUTE, this.minute);
        date.set(Calendar.SECOND, this.second);
        // Schedule to run at this time/
        return date.getTime();
    }

    /**
     * run application.
     *
     * @param args args.
     * @throws SQLException ex.
     */
    public static void main(String[] args) throws SQLException {
        MyTaskTimer taskTimer = new MyTaskTimer(3, 29, 0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(taskTimer, taskTimer.getDateOfStart(), 1000 * 60 * 60 * 24);
    }

}
