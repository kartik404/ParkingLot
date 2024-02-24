package LLD.ParkingLot.model;

import java.util.List;

public class Floor {
    private List<ParkingSlot> slots;

    public Floor(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
