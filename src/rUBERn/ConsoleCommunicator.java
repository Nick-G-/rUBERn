package rUBERn;

// Created by nico on 10/3/16.

import java.util.Scanner;

public class ConsoleCommunicator {
    public static void main(String[] args) {
        System.out.println("rUBERn");
        DriverManager driverManager = new DriverManager();
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        while (on) {
            System.out.println("Menu: ");
            System.out.println("1. Dar de alta chofer");
            System.out.println("2. Dar de alta cliente");
            System.out.println("3. Alterar estado de los choferes");
            System.out.println("4. Pedir viaje como cliente");
            System.out.println("5. Salir");
            switch (scanner.nextInt()) {
                case 1:
                    driverManager.addDriver(createDriver());
                case 2:
                    createClient();
                case 3:
                    showDrivers();
                case 4:
                    showClients();
                case 5:
                    on = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    private static Driver createDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del chofer: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese los datos del auto del chofer:");
        System.out.println("Categoria: ");
        String category = scanner.nextLine();
        System.out.println("Ingrese la capacidad del auto: ");
        int capacity = scanner.nextInt();
        Driver driver = new Driver(new CreditCard(),new Location(),name, new Car(capacity, category));
        return driver;
    }

    private static void createClient() {

    }

    private static void showDrivers() {

    }
    private static void showClients(){

    }
}