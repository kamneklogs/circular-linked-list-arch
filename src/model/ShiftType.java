package model;

public class ShiftType {

    private String name;
    private double time;

    private ShiftType nextShiftType;

    public ShiftType(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ShiftType getNextShiftType() {
        return nextShiftType;
    }

    public void setNextShiftType(ShiftType nextShiftType) {
        this.nextShiftType = nextShiftType;
    }

}