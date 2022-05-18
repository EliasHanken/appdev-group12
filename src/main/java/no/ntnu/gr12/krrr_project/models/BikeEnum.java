package no.ntnu.gr12.krrr_project.models;

public enum BikeEnum {

    BIKE_RED("RED",1L),
    BIKE_PURPLE("PURPLE",2L),
    BIKE_BLUE("BLUE",3L),
    BIKE_GREEN("GREEN",4L);

    String name;
    Long modelId;

    BikeEnum(String n, Long m) {
        this.name = n;
        this.modelId = m;
    }

    public String getName(){
        return this.name;
    }

    public Long getModelId(){
        return this.modelId;
    }

    public String getModelIdString(){
        return String.valueOf(this.modelId);
    }


}
