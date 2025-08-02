package machineCoding.taskManagement.sortstrategy;
import java.util.List;
import machineCoding.taskManagement.Task;

public interface TaskSortingStrategy{
    void sort(List<Task> tasks);
}