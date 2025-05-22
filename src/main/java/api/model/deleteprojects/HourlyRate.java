package api.model.deleteprojects; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class HourlyRate{
    @JsonProperty("amount") 
    public int getAmount() { 
		 return this.amount; } 
    public void setAmount(int amount) { 
		 this.amount = amount; } 
    int amount;
    @JsonProperty("currency") 
    public String getCurrency() { 
		 return this.currency; } 
    public void setCurrency(String currency) { 
		 this.currency = currency; } 
    String currency;
}
