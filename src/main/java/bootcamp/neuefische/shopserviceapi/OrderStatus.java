package bootcamp.neuefische.shopserviceapi;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    PROCESSING("processing"),
    IN_DELIVERY("in_delivery"),
    COMPLETED("completed");

    private final String status;

    public String getStatus(){
        return status;
    }

}
