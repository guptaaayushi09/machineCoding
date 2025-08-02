package machineCoding.taskManagement;

import java.util.UUID;
import java.util.Date;

public class ActivityLog{
    private final String logId;
    private final String action;
    private final User performedBy;
    private final Date time;
    public ActivityLog(String action, User performedBy){
        this.logId = UUID.randomUUID().toString();
        this.time = new Date();
        this.action = action;
        this.performedBy = performedBy;
    }
    
}