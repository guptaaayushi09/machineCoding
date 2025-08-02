package machineCoding.taskManagement;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import machineCoding.taskManagement.sortstrategy.TaskSortingStrategy;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.RuntimeErrorException;
public class TaskManagementSystem {
    private static TaskManagementSystem instance;
    private final Map<String,User> users;
    private final Map<String,Task> tasks;
    private final Map<String,TaskList> taskLists;

    private TaskManagementSystem(){
    users = new ConcurrentHashMap<>();
    tasks = new ConcurrentHashMap<>();
    taskLists = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManagementSystem getInstance(){
        if(instance == null) {
        instance = new TaskManagementSystem();
        }
        return instance;
    }
    public User createUser(String name, String email){
        User user = new User(name, email);
        users.put(user.getId(),user);
        return user;
    }
    public TaskList createTaskList(String lisName){
        TaskList tasklist = new TaskList(lisName);
        taskLists.put(tasklist.getId(),tasklist);
        return tasklist;
    }

    public Task createTask(String listId,
                        String title,
                        String description,
                        TaskPriority priority,
                        Date dueDate,
                        String createdByUserId){
    TaskList taskList = taskLists.get(listId);
    if(taskList == null) throw new IllegalArgumentException("TaskList not found");

    User createdBy = users.get(createdByUserId);
    if(createdBy == null) throw new IllegalArgumentException("User not found");

       Task task = new Task(title,description,dueDate,priority,createdBy);
       tasks.put(task.getId(), task);
       taskList.addTask(task);
       return task;
    }
    public Task getTaskById(String taskId){
       if(!tasks.containsKey(taskId)) throw new RuntimeException("Task not found"+taskId);
        return tasks.get(taskId);
    }
    public void updateTaskStatus(String taskId,TaskStatus taskStatus){
        getTaskById(taskId).updateStatus(taskStatus);
    }
    public void updateTaskPriority(String taskId,TaskPriority priority){
        getTaskById(taskId).updatePriority(priority);
    }
    public void assignTask(String userId,String taskId){
        User user = users.get(userId);
        if(user == null) throw new IllegalArgumentException("User Id not found");
        getTaskById(taskId).assignUser(user);
    }
    public void addComment(String comment,User author,String taskId){
    Task task = getTaskById(taskId);
    task.addComment(new Comment(comment, author));
    }
    public List<Task> listTaskByStatus(TaskStatus status){
        return tasks.values().stream().filter(task -> task.getStatus() == status).toList();
      
    }
    public List<Task> listTaskByUser(String userId){
      User user = users.get(userId);
      return tasks.values().stream().filter(task -> user.equals(task.getAssignedTo())).toList();

    }
    public void deleteTask(String taskId){
        tasks.remove(taskId);
    }
    public List<Task> searchTask(String keyword, TaskSortingStrategy taskSortingStrategy) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        taskSortingStrategy.sort(matchingTasks);
        return matchingTasks;
    }
}
