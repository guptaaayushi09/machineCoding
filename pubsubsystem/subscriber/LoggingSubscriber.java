package machineCoding.pubsubsystem.subscriber;

import machineCoding.pubsubsystem.Message;

public class LoggingSubscriber implements Subscriber{
    private final String name;

    public LoggingSubscriber(String name){
        this.name = name;
    }

    @Override
    public void Consume(Message message){
     System.out.println("Subscriber" + name +"received messages: "+ message.getConetent());
    }
}
