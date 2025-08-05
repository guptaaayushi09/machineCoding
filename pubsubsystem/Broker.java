package machineCoding.pubsubsystem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import machineCoding.pubsubsystem.subscriber.*;;

public class Broker {
    private final Map<String,Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String name){
  topics.putIfAbsent(name, new Topic(name));
    }

    public void subscribe(String topicName,Subscriber subscriber){
       Topic topic = topics.get(topicName);
       if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.addSubscriber(subscriber);
    }
    public void unsubscribe(String topicName,Subscriber subscriber){
     Topic topic = topics.get(topicName);
     if(topic == null) throw new IllegalArgumentException("Topic not found: "+ topicName);
        topic.removeSubscriber(subscriber);
    }
    public void publish(String topicName ,Message message){
      Topic topic = topics.get(topicName);
      if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
       topic.broadCast(message);
    }

}
