package machineCoding.pubsubsystem;

import machineCoding.pubsubsystem.subscriber.*;;;

public class PubSubDemo {
    public static void main(String[] args){
        Broker broker = new Broker();

        broker.createTopic("Topic 1");
        broker.createTopic("Topic 2");

        Publisher publisher1 = new Publisher("publisher 1", broker);
        Publisher publisher2 = new Publisher("publisher 2", broker);

        Subscriber subscriber1 = new PrintSubscriber("PrintSubscriber1");
        Subscriber subscriber2 = new PrintSubscriber("PrintSubscriber2");
        Subscriber subscriber3 = new LoggingSubscriber("LoggSubscriber3");

        broker.subscribe("Topic 1", subscriber1);
        broker.subscribe("Topic 1", subscriber2);
        broker.subscribe("Topic 2", subscriber3);

        publisher1.publish("Topic 1","Message1 for Topic1");
        publisher1.publish("Topic 2","Message 1 for Topic2");
        publisher2.publish("Topic 2","Message 1 for topic 3");

 // Unsubscribe from a topic
 broker.unsubscribe("Topic 1", subscriber2);

 // Publish more messages
 publisher1.publish("Topic 1", "Message3 for Topic1");
 publisher2.publish("Topic 2", "Message2 for Topic2");

 try {
     Thread.sleep(100); // Allow async delivery
     Dispatcher.shutDown();
 } catch (InterruptedException e) {
     System.out.println("Interrupted exception");
 }



    }
}
