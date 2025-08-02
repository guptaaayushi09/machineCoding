package machineCoding.taskManagement;

import java.util.UUID;
import machineCoding.taskManagement.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskList {
    private final String id;
    private final String name;
    private final List<Task> tasks;
    public TaskList(String name ){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tasks = new CopyOnWriteArrayList<>();

        
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public List<Task> getTask(){
        return  new ArrayList<>(tasks);
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
