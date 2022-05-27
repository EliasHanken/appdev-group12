package no.ntnu.gr12.krrr_project.dto;

public class OrderUpdateRequest {
    private final String id;
    private final String destination;
    private final String shippedFlag;

    public OrderUpdateRequest(String id, String destination, String shippedFlag){
        this.id = id;
        this.destination = destination;
        this.shippedFlag = shippedFlag;
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getShippedFlag() {
        return shippedFlag;
    }
}
