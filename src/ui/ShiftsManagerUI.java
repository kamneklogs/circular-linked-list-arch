package ui;

import model.*;

public class ShiftsManagerUI {

    public static void main(String[] args) {

        ShiftsManager myShiftsManager = new ShiftsManager();

        myShiftsManager.addShiftType("comida", 1232);
        myShiftsManager.addShiftType("salud", 32723);
        myShiftsManager.addShiftType("administracion", 112);
        myShiftsManager.addShiftType("quejas", 2799);
        myShiftsManager.addShiftType("peticiones", 213232);

        System.out.println(myShiftsManager.report());


        System.out.println(myShiftsManager.report());
        

        

        myShiftsManager.addPerson("carlos", "123");
        myShiftsManager.addPerson("andre", "221");
        myShiftsManager.addPerson("aro", "34");
        myShiftsManager.addPerson("asdw", "4353");
        myShiftsManager.addPerson("ewwca", "14345");
        myShiftsManager.addPerson("awdc", "123324");
        myShiftsManager.addPerson("rgae", "2143345");

        System.out.println(myShiftsManager.reportPeople());

        System.out.println(myShiftsManager.searchPerson("123").getName());

    }

}