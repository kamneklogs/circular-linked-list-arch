package model;

import java.util.ArrayList;

public class ShiftsManager {

    private ShiftType firstShiftType;
    private Person people;

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

    public ShiftType searchShiftType(String name) {

        ShiftType result = null;

        for (ShiftType s = firstShiftType; s.getNextShiftType() != firstShiftType; s = s.getNextShiftType()) {

            if (s.getName().equals(name)) {
                result = s;
                break;
            }

        }

        return result;

    }

    public ShiftType removeShiftType(String name) {

        ShiftType current = firstShiftType;

        if (current.getName().equals(name)) {

            ShiftType lastShiftType = current.getNextShiftType();

            while (lastShiftType.getNextShiftType() != firstShiftType) {
                lastShiftType = lastShiftType.getNextShiftType();
            }

            lastShiftType.setNextShiftType(firstShiftType.getNextShiftType());

            firstShiftType = firstShiftType.getNextShiftType();

        } else {

            ShiftType previous = null;

            while (!current.getName().equals(name) && current.getNextShiftType() != firstShiftType) {
                previous = current;
                current = current.getNextShiftType();
            }

            if (current.getName().equals(name)) {
                previous.setNextShiftType(current.getNextShiftType());
            }

        }

        return current;

    }

    public void bubbleSortByName() {

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
        String report = " || " + firstShiftType.getName() + " || ";

        for (ShiftType s = firstShiftType.getNextShiftType(); s != firstShiftType; s = s.getNextShiftType()) {
            report += s.getName() + " || ";
        }

        return report;
    }

    public void removeTimeGreaterThan(Double timeLimit) {

        ArrayList<String> shiftTypesToRemove = new ArrayList<String>();

        if (firstShiftType.getTime() > timeLimit) {
            shiftTypesToRemove.add(firstShiftType.getName());
        }

        for (ShiftType s = firstShiftType.getNextShiftType(); s != firstShiftType; s = s.getNextShiftType()) {
            if (s.getTime() > timeLimit) {
                shiftTypesToRemove.add(s.getName());
            }

        }

        for (String s : shiftTypesToRemove) {
            removeShiftType(s);
        }

    }

    public void addPerson(String name, String id) {
        Person newPerson = new Person(name, id);

        if (people == null) {
            people = newPerson;
        } else {

            Person current = people;

            while (current.getNextPerson() != null) {
                current = current.getNextPerson();
            }

            current.setNextPerson(newPerson);
            newPerson.setPrevPerson(current);

        }

    }

    public Person searchPerson(String id) {

        for (Person current = people; current != null; current = current.getNextPerson()) {
            if (current.getId().equals(id)) {
                return current;
            }
        }

        return null;
    }

    public void selectionSortById() {

        Person p = people.getNextPerson();
        Person max = p.getNextPerson();
        boolean flag;
        while (p != null) {

            flag = true;
            while (flag == true && p.getPrevPerson() != null) {
                flag = false;
                if (p.getPrevPerson().getId().compareTo(p.getId()) > 1) {


                    Person s = null, r = null, q = p, newP = p.getPrevPerson();
                    if (newP.getNextPerson() != q) {
                        s = newP.getNextPerson();
                        r = q.getPrevPerson();
                    }
                    newP.setNextPerson(q.getNextPerson());
                    q.setPrevPerson(newP.getPrevPerson());
                    if (q.getNextPerson() != null) {
                        q.getNextPerson().setPrevPerson(newP);
                    }
                    if (newP.getPrevPerson() != null) {
                        newP.getPrevPerson().setNextPerson(q);
                    } else {
                        people = q;
                    }
                    if (s != null && r != null) {
                        r.setNextPerson(newP);
                        s.setPrevPerson(q);
                        q.setNextPerson(s);
                        newP.setPrevPerson(r);
                    } else {
                        q.setNextPerson(newP);
                        newP.setPrevPerson(q);
                    }

                    flag = true;
                }else if(p.getPrevPerson().getId().compareTo(p.getId()) < 1){

                    Person s = null, r = null, q = p.getPrevPerson(), newP = p;
                    if (newP.getNextPerson() != q) {
                        s = newP.getNextPerson();
                        r = q.getPrevPerson();
                    }
                    newP.setNextPerson(q.getNextPerson());
                    q.setPrevPerson(newP.getPrevPerson());
                    if (q.getNextPerson() != null) {
                        q.getNextPerson().setPrevPerson(newP);
                    }
                    if (newP.getPrevPerson() != null) {
                        newP.getPrevPerson().setNextPerson(q);
                    } else {
                        people = q;
                    }
                    if (s != null && r != null) {
                        r.setNextPerson(newP);
                        s.setPrevPerson(q);
                        q.setNextPerson(s);
                        newP.setPrevPerson(r);
                    } else {
                        q.setNextPerson(newP);
                        newP.setPrevPerson(q);
                    }

                    flag = true;

                }
            }
            p = max;
            if (p != null) {
                max = p.getNextPerson();
            }
        }
    }

    public String reportPerson() {
        String s = "";

        for (Person current = people; current != null; current = current.getNextPerson()) {
            s += " || " + current.getName() + " " +  current.getId() + " || ";
        }

        return s;
    }

}
