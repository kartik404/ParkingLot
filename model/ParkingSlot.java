package LLD.ParkingLot.model;

import LLD.ParkingLot.enums.VehicleType;

public class ParkingSlot {
    private boolean reserved;
    private final VehicleType vehicleType;

    public ParkingSlot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
