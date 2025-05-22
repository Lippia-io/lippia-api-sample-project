package api.model.deleteprojects; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class TimeEstimate{
    @JsonProperty("estimate") 
    public String getEstimate() { 
		 return this.estimate; } 
    public void setEstimate(String estimate) { 
		 this.estimate = estimate; } 
    String estimate;
    @JsonProperty("type") 
    public String getType() { 
		 return this.type; } 
    public void setType(String type) { 
		 this.type = type; } 
    String type;
    @JsonProperty("resetOption") 
    public Object getResetOption() { 
		 return this.resetOption; } 
    public void setResetOption(Object resetOption) { 
		 this.resetOption = resetOption; } 
    Object resetOption;
    @JsonProperty("active") 
    public boolean getActive() { 
		 return this.active; } 
    public void setActive(boolean active) { 
		 this.active = active; } 
    boolean active;
    @JsonProperty("includeNonBillable") 
    public boolean getIncludeNonBillable() { 
		 return this.includeNonBillable; } 
    public void setIncludeNonBillable(boolean includeNonBillable) { 
		 this.includeNonBillable = includeNonBillable; } 
    boolean includeNonBillable;
}
