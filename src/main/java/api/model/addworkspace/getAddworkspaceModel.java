package api.model.addworkspace; 
import java.util.ArrayList;

public class getAddworkspaceModel {
    public String id;
    public String name;
    public HourlyRate hourlyRate;
    public CostRate costRate;
    public ArrayList<Membership> memberships;
    public WorkspaceSettings workspaceSettings;
    public String imageUrl;
    public String featureSubscriptionType;
    public ArrayList<String> features;
    public ArrayList<Object> currencies;
    public Subdomain subdomain;
}
