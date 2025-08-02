package machineCoding.taskManagement.sortstrategy;
import  machineCoding.taskManagement.Task;

import java.util.Comparator;
import java.util.List;

public class SortByPriority implements TaskSortingStrategy{
 @Override
 public void sort(List<Task> tasks){

    tasks.sort(Comparator.comparing(Task::getTaskPriority).reversed());
 }
}