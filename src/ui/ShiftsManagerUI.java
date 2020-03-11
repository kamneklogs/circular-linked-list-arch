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

        System.out.println("\nLista Circular sin ordenar:\n");
        System.out.println(myShiftsManager.report());


        myShiftsManager.removeShiftType("peticiones");
        System.out.println(myShiftsManager.report());

    }

}