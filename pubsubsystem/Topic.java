package machineCoding.pubsubsystem;
import java.util.Set;
import machineCoding.pubsubsystem.subscriber.Subscriber;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
   private final Set<Subscriber> subscribes = new CopyOnWriteArraySet<>();

    public Topic(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addSubscriber(Subscriber s){
        subscribes.add(s);
    }
    
    public void removeSubscriber(Subscriber s){
        subscribes.remove(s);
    }

    public void broadCast(Message message){
    for(Subscriber s : subscribes){
        Dispatcher.dispatch(s, message);    
    }
}

}
