package machineCoding.pubsubsystem.subscriber;
import machineCoding.pubsubsystem.Message;

public interface Subscriber {
    void Consume(Message message);
}
