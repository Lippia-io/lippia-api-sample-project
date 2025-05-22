package api.model.allprojects; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class getAllprojectsModel {
    public String id;
    public String name;
    public HourlyRate hourlyRate;
    public String clientId;
    public String workspaceId;
    public boolean billable;
    public ArrayList<Membership> memberships;
    public String color;
    public Estimate estimate;
    public boolean archived;
    public String duration;
    public String clientName;
    public String note;
    public Object costRate;
    public TimeEstimate timeEstimate;
    public Object budgetEstimate;
    public Object estimateReset;
    public boolean template;
    @JsonProperty("public") 
    public boolean mypublic;
}
