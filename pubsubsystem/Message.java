package machineCoding.pubsubsystem;

public class Message {
  private final String content;

  public Message(String content){
    this.content = content;
  }    
 
  public String getConetent(){
    return this.content;
  }
  @Override
  public String toString() {
    return "Message {" +"content '" + content + '\'' + "}";
}
}
