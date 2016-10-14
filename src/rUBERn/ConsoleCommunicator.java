package rUBERn;

// Created by nico on 10/3/16.

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleCommunicator {
    public static void main(String[] args) {
        System.out.println("rUBERn");
        DriverManager driverManager = new DriverManager();
        ArrayList<Client> clients = new ArrayList<>();
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        while (on) {
            System.out.println("Menu: ");
            System.out.println("1. Dar de alta chofer");
            System.out.println("2. Dar de alta cliente");
            System.out.println("3. Alterar estado de los choferes");
            System.out.println("4. Pedir viaje como cliente");
            System.out.println("5. Salir");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    driverManager.addDriver(createDriver());
                    break;
                case 2:
                    clients.add(createClient());
                    break;
                case 3:
                    //todo driverManager.showDrivers();
                    break;
                case 4:
                    //todo showClients();
                    break;
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
        System.out.println("Ingrese la ubicacion del chofer x:");
        long x = scanner.nextLong();
        System.out.println("Ingrese la ubicacion del chofer y:");
        long y = scanner.nextLong();
        return new Driver(new CreditCard(),new Location(x,y),name, new Car(capacity, category));
    }

    private static Client createClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese la ubicacion del Cliente x:");
        long x = scanner.nextLong();
        System.out.println("Ingrese la ubicacion del Cliente y:");
        long y = scanner.nextLong();
        return new Client(new CreditCard(), new Location(x,y),name);
    }
}