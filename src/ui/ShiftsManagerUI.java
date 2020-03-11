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
        

        

        myShiftsManager.addPerson("carlos", "a");
        myShiftsManager.addPerson("andre", "d");
        myShiftsManager.addPerson("aro", "g");
        myShiftsManager.addPerson("asdw", "i");
        myShiftsManager.addPerson("ewwca", "h");
        myShiftsManager.addPerson("awdc", "b");
        myShiftsManager.addPerson("rgae", "c");

        System.out.println(myShiftsManager.reportPerson());

        myShiftsManager.selectionSortById();

        System.out.println(myShiftsManager.reportPerson());


    }

}