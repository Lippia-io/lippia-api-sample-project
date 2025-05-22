package api.model.deleteprojects; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Membership{
    @JsonProperty("userId") 
    public String getUserId() { 
		 return this.userId; } 
    public void setUserId(String userId) { 
		 this.userId = userId; } 
    String userId;
    @JsonProperty("hourlyRate") 
    public Object getHourlyRate() { 
		 return this.hourlyRate; } 
    public void setHourlyRate(Object hourlyRate) { 
		 this.hourlyRate = hourlyRate; } 
    Object hourlyRate;
    @JsonProperty("costRate") 
    public Object getCostRate() { 
		 return this.costRate; } 
    public void setCostRate(Object costRate) { 
		 this.costRate = costRate; } 
    Object costRate;
    @JsonProperty("targetId") 
    public String getTargetId() { 
		 return this.targetId; } 
    public void setTargetId(String targetId) { 
		 this.targetId = targetId; } 
    String targetId;
    @JsonProperty("membershipType") 
    public String getMembershipType() { 
		 return this.membershipType; } 
    public void setMembershipType(String membershipType) { 
		 this.membershipType = membershipType; } 
    String membershipType;
    @JsonProperty("membershipStatus") 
    public String getMembershipStatus() { 
		 return this.membershipStatus; } 
    public void setMembershipStatus(String membershipStatus) { 
		 this.membershipStatus = membershipStatus; } 
    String membershipStatus;
}
