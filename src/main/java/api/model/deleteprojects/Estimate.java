package api.model.deleteprojects; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Estimate{
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
}
