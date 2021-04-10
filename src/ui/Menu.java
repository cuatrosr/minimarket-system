package ui;

import exceptions.ExceptionDocument;
import exceptions.ExceptionGoberment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Minimarket;

public class Menu {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Minimarket mm = new Minimarket();

    public void startProgram() {
        int choice;
        do {
            showMenu();
            choice = getChoice();
            doChoice(choice);
        } while (choice != 3);
    }

    public void showMenu() {
        System.out.println("----------------------------------------------------");
        System.out.println("(1) Registrar el ingreso de una nueva persona");
        System.out.println("(2) Cantidad de personas que han intentado ingresar");
        System.out.println("(3) Salir del programa");
        System.out.println("----------------------------------------------------");
    }

    public int getChoice() {
        boolean out = false;
        int choice = 0;
        do {
            System.out.println("Ingrese una opcion:");
            try {
                choice = Integer.parseInt(br.readLine());
                out = (choice > 0 && choice < 4);
                if (!out) {
                    System.out.println("Debe ingresar una opcion de 1 a 3");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("No puede ingresar letras en el menu");
            }
        } while (!out);
        return choice;
    }

    public void doChoice(int choice) {
        switch (choice) {
            case 1:
                registerClient();
                break;
            case 2:
                System.out.println(ammountClient());
                break;
            default:
                System.exit(0);
        }
    }

    public void registerClient() {
        try {
            System.out.println("Ingrese su documento de los siguientes:");
            System.out.println("TI - CC - PP - CE");
            String document = br.readLine();
            System.out.println("Ingrese su numero de identificacion:");
            long docInt = Long.parseLong(br.readLine());
            System.out.println("Ingrese el numero del dia de hoy");
            int day = Integer.parseInt(br.readLine());
            mm.registerClient(document, docInt, day);
        } catch (Exception e) {
            System.out.println("Revise la informacion que ha puesto");
            registerClient();
        }
    }

    public int ammountClient() {
    	return mm.getTryIn();
    }
}
