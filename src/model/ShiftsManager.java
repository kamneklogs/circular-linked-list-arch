package model;

public class ShiftsManager {

    private ShiftType firstShiftType;

    public ShiftsManager() {

    }

    public void addShiftType(String name, double time) {
        ShiftType newShiftType = new ShiftType(name, time);

        if (firstShiftType == null) {
            firstShiftType = newShiftType;
            firstShiftType.setNextShiftType(firstShiftType);
        } else {

            ShiftType current = firstShiftType;

            while (current.getNextShiftType() != null && current.getNextShiftType() != firstShiftType) {

                current = current.getNextShiftType();

            }

            current.setNextShiftType(newShiftType);
            current.getNextShiftType().setNextShiftType(firstShiftType);

        }

    }

    public void sortByName() {

        ShiftType currentType = firstShiftType;

        while (currentType.getNextShiftType() != firstShiftType) {
            currentType = currentType.getNextShiftType();
        }

        currentType.setNextShiftType(null);

        if (firstShiftType != null) {

            if (firstShiftType.getNextShiftType() != null) {

                boolean change;

                do {
                    ShiftType current = firstShiftType;
                    ShiftType previous = null;
                    ShiftType next = firstShiftType.getNextShiftType();
                    change = false;
                    while (next != null) {
                        if (current.getName().compareTo(next.getName()) > 0) {
                            change = true;
                            if (previous != null) {
                                ShiftType newNext = next.getNextShiftType();
                                previous.setNextShiftType(next);
                                next.setNextShiftType(current);
                                current.setNextShiftType(newNext);
                            } else {
                                ShiftType newNext = next.getNextShiftType();
                                firstShiftType = next;
                                next.setNextShiftType(current);
                                current.setNextShiftType(newNext);
                            }
                            previous = next;
                            next = current.getNextShiftType();
                        } else {
                            previous = current;
                            current = next;
                            next = next.getNextShiftType();
                        }
                    }
                } while (change);
            }
        }

        currentType = firstShiftType;

        while (currentType.getNextShiftType() != null) {
            currentType = currentType.getNextShiftType();
        }
        currentType.setNextShiftType(firstShiftType);

    }

    public String report() {
        String report = firstShiftType.getName() + " ";

        for (ShiftType s = firstShiftType.getNextShiftType(); s != firstShiftType; s = s.getNextShiftType()) {
            report += s.getName() + " ";
        }

        return report;
    }

}
