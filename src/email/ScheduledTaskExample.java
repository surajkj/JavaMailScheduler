/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;
import java.util.concurrent.*;
import java.util.*;
/**
 *
 * @author SurajK
 */
public class ScheduledTaskExample {
    private final ScheduledExecutorService scheduler = Executors
        .newScheduledThreadPool(1);

    public void startScheduleTask() {
    /**
    * not using the taskHandle returned here, but it can be used to cancel
    * the task, or check if it's done (for recurring tasks, that's not
    * going to be very useful)
    */
    final ScheduledFuture<?> taskHandle = scheduler.scheduleAtFixedRate(
        new Runnable() {
            public void run() {
                try {
                    getDataFromDatabase();
                }catch(Exception ex) {
                    ex.printStackTrace(); //or loggger would be better
                }
            }
        }, 0, 2, TimeUnit.MINUTES);
    }

    private void getDataFromDatabase() {
        System.out.println("Sending Mail...");
        String from = "ShrikantKatakdhond@ltfs.com";
        String pass = "password";
        String[] to = { "Surajkanojiya@ltfs.com" };
        String subject = "Java send mail example from Scheduler";
        String body = "hi ....,!";
//        Email email=new Email();
        Email.sendFromGMail(from, pass, to, subject, body);
        System.out.println("Time Mail sent "+ new Date());
    }

    public static void main(String[] args) {
        ScheduledTaskExample ste = new ScheduledTaskExample();
        ste.startScheduleTask();
    }
}
