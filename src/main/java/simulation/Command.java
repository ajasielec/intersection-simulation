package simulation;

public class Command {
    private String type;
    private String vehicleId;
    private String startRoad;
    private String endRoad;

    // getters and setters
    public String getType(){return type;}
    public String getVehicleId(){return vehicleId;}
    public String getStartRoad(){return startRoad;}
    public String getEndRoad(){return endRoad;}

    public void setType(String type){this.type = type;}
    public void setVehicleId(String vehicleId){this.vehicleId = vehicleId;}
    public void setStartRoad(String startRoad){this.startRoad = startRoad;}
    public void setEndRoad(String endRoad){this.endRoad = endRoad;}
}
