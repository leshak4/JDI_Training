package com.epam.jdi.uitests.testing.appln.utils;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Calendar;

/**
 * Created by Aleksei_Abramenko on 4/14/2016.
 */
public class Utils {

    private static final Logger log = Logger.getLogger("Utils");

    public static String getCurrentYear() {
        return "" + Calendar.getInstance().get(Calendar.YEAR);
    }

    public static void pressPageDown(int num) {
        log.info("Pressing PageDown key " + num + " times");
        try {
            Robot robot = new Robot();
            for (int i = 1; i <= num; i ++) {
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                sleep(500);
            }
            log.info("PageDown key has been pressed " + num + " times");
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
