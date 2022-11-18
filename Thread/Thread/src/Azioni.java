import java.util.ArrayList;

public class Azioni extends Thread{

    ActivityCounter activityCounter;
    ArrayList<Thread> waitfor;
    int seconds;
    int activityNumber;


    public Azioni(int activityNumber, int seconds, ArrayList<Thread> waitfor, ActivityCounter activityCounter){
        this.activityNumber=activityNumber;
        this.seconds=seconds;
        this.waitfor=waitfor;
        this.activityCounter=activityCounter;
    }

    public void run(){

        //First thing to do -> check if is ypur turn so join until you can go
        for(Thread thread: waitfor){
            try{
                thread.join();
            }catch(InterruptedException e){
                System.out.println("Interrupted Exception");
            }
        }

        System.out.println("Azione "+ activityNumber + "\nContatore attività: " + activityCounter);

        try{
            Thread.sleep(seconds * 1000L);
        }catch(InterruptedException e){
            System.out.println("Interrupted exception");
        }

        activityCounter.add();
    }
}
