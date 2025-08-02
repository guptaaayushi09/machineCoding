package machineCoding.taskManagement.sortstrategy;
import machineCoding.taskManagement.Task;
import java.util.List;
import java.util.Comparator;


public class SortByDueDate implements TaskSortingStrategy {
    @Override
     public void sort(List<Task> tasks){
       tasks.sort(Comparator.comparing(Task:: getDueDate));
     }
    
}
