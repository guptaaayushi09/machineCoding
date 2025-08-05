package machineCoding.pubsubsystem.subscriber;

import machineCoding.pubsubsystem.Message;

public class PrintSubscriber implements Subscriber{
    private final String name;
    public PrintSubscriber(String name){
        this.name = name;
    }
   
    @Override
    public void Consume(Message message){
       System.out.println("Subscriber" + name +"received messages: "+ message.getConetent());
    }    
}
