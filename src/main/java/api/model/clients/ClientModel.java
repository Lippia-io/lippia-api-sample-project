package api.model.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientModel {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    @JsonProperty("workspaceId")
    public String getWorkspaceId() {
        return this.workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    String workspaceId;

    @JsonProperty("archived")
    public boolean getArchived() {
        return this.archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    boolean archived;

    @JsonProperty("address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;

    @JsonProperty("note")
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    String note;

    @JsonProperty("currencyId")
    public String getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    String currencyId;

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    String currencyCode;
}
