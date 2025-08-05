package machineCoding.pubsubsystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import machineCoding.pubsubsystem.subscriber.Subscriber;

public class Dispatcher {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void dispatch(Subscriber subscriber, Message message){
        executor.submit(()->{
            try{
                subscriber.Consume(message);

            }
            catch(Exception e){
   System.out.println("Dispatcher error:" + e.getMessage());
            }
        });

    }
    public static void shutDown(){
        executor.shutdown();
    }
    
}
