package api.model.addprojects; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class AddProjectModel{
    @JsonProperty("id") 
    public String getId() { 
		 return this.id; } 
    public void setId(String id) { 
		 this.id = id; } 
    String id;
    @JsonProperty("name") 
    public String getName() { 
		 return this.name; } 
    public void setName(String name) { 
		 this.name = name; } 
    String name;
    @JsonProperty("hourlyRate") 
    public HourlyRate getHourlyRate() { 
		 return this.hourlyRate; } 
    public void setHourlyRate(HourlyRate hourlyRate) { 
		 this.hourlyRate = hourlyRate; } 
    HourlyRate hourlyRate;
    @JsonProperty("clientId") 
    public String getClientId() { 
		 return this.clientId; } 
    public void setClientId(String clientId) { 
		 this.clientId = clientId; } 
    String clientId;
    @JsonProperty("workspaceId") 
    public String getWorkspaceId() { 
		 return this.workspaceId; } 
    public void setWorkspaceId(String workspaceId) { 
		 this.workspaceId = workspaceId; } 
    String workspaceId;
    @JsonProperty("billable") 
    public boolean getBillable() { 
		 return this.billable; } 
    public void setBillable(boolean billable) { 
		 this.billable = billable; } 
    boolean billable;
    @JsonProperty("memberships") 
    public ArrayList<Membership> getMemberships() {
		 return this.memberships; } 
    public void setMemberships(ArrayList<Membership> memberships) { 
		 this.memberships = memberships; } 
    ArrayList<Membership> memberships;
    @JsonProperty("color") 
    public String getColor() { 
		 return this.color; } 
    public void setColor(String color) { 
		 this.color = color; } 
    String color;
    @JsonProperty("estimate") 
    public Estimate getEstimate() { 
		 return this.estimate; } 
    public void setEstimate(Estimate estimate) { 
		 this.estimate = estimate; } 
    Estimate estimate;
    @JsonProperty("archived") 
    public boolean getArchived() { 
		 return this.archived; } 
    public void setArchived(boolean archived) { 
		 this.archived = archived; } 
    boolean archived;
    @JsonProperty("duration") 
    public String getDuration() { 
		 return this.duration; } 
    public void setDuration(String duration) { 
		 this.duration = duration; } 
    String duration;
    @JsonProperty("clientName") 
    public String getClientName() { 
		 return this.clientName; } 
    public void setClientName(String clientName) { 
		 this.clientName = clientName; } 
    String clientName;
    @JsonProperty("note") 
    public String getNote() { 
		 return this.note; } 
    public void setNote(String note) { 
		 this.note = note; } 
    String note;
    @JsonProperty("costRate") 
    public Object getCostRate() { 
		 return this.costRate; } 
    public void setCostRate(Object costRate) { 
		 this.costRate = costRate; } 
    Object costRate;
    @JsonProperty("timeEstimate") 
    public TimeEstimate getTimeEstimate() { 
		 return this.timeEstimate; } 
    public void setTimeEstimate(TimeEstimate timeEstimate) { 
		 this.timeEstimate = timeEstimate; } 
    TimeEstimate timeEstimate;
    @JsonProperty("budgetEstimate") 
    public Object getBudgetEstimate() { 
		 return this.budgetEstimate; } 
    public void setBudgetEstimate(Object budgetEstimate) { 
		 this.budgetEstimate = budgetEstimate; } 
    Object budgetEstimate;
    @JsonProperty("estimateReset") 
    public Object getEstimateReset() { 
		 return this.estimateReset; } 
    public void setEstimateReset(Object estimateReset) { 
		 this.estimateReset = estimateReset; } 
    Object estimateReset;
    @JsonProperty("template") 
    public boolean getTemplate() { 
		 return this.template; } 
    public void setTemplate(boolean template) { 
		 this.template = template; } 
    boolean template;
    @JsonProperty("public") 
    public boolean getMypublic() { 
		 return this.mypublic; } 
    public void setMypublic(boolean mypublic) { 
		 this.mypublic = mypublic; } 
    boolean mypublic;
}
