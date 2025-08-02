package machineCoding.taskManagement;

import java.util.Date;
import java.util.List;

import machineCoding.taskManagement.sortstrategy.SortByDueDate;

public class TaskManagementSystemDemo {
    public static void main(String[] args){
        TaskManagementSystem taskManagementSystem =  TaskManagementSystem.getInstance();

        User user1 = taskManagementSystem.createUser("Aayushi","aayushi0901@gmail.com");
        User user2 = taskManagementSystem.createUser("Riya", "riya2902@gmail.com");

        TaskList taskL1 = taskManagementSystem.createTaskList("Bug Fix");
        TaskList taskL2 = taskManagementSystem.createTaskList("Enhancement");


       Task task1 = taskManagementSystem.createTask(taskL1.getId(), "Task 1", "Description 1", TaskPriority.LOW, new Date(), user1.getId());
       Task task2 = taskManagementSystem.createTask(taskL1.getId(), "Task 2", "Description 2", TaskPriority.MEDIUM, new Date(), user1.getId());
       Task task3 = taskManagementSystem.createTask(taskL2.getId(), "Task 3", "Description 3", TaskPriority.HIGH, new Date(), user2.getId());


     taskManagementSystem.updateTaskStatus(task2.getId(), TaskStatus.IN_PROGRESS);
     taskManagementSystem.updateTaskPriority(task1.getId(),TaskPriority.CRITICAL);

     taskManagementSystem.assignTask(user1.getId(), task1.getId());
     taskManagementSystem.assignTask(user2.getId(), task2.getId());


     List<Task> searchTask = taskManagementSystem.searchTask("Task", new SortByDueDate());
    
     for(Task task : searchTask){
        System.out.println(task.getDescription() + "task listed");
     }
    List<Task> taskStatus = taskManagementSystem.listTaskByStatus(TaskStatus.IN_PROGRESS);
    for(Task task : taskStatus){
        System.out.println("task status  in progress ids"+task.getId());
    }
    List<Task>taskUser = taskManagementSystem.listTaskByUser(user1.getId());
    for(Task task : taskUser){
        System.out.println("task of user 2 "+ task.getTitle());
    }



     taskManagementSystem.updateTaskStatus(task2.getId(),TaskStatus.DONE );

     taskManagementSystem.deleteTask(task2.getId());
    }
}
