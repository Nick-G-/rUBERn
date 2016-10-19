package rUBERn;

// Created by nico on 10/3/16.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCommunicator {
    public static void main(String[] args) {
        System.out.println("rUBERn");
        rUBERn ruben = new rUBERn();
        ArrayList<Client> clients = new ArrayList<>();
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        while (on) {
            System.out.println("Menu: ");
            System.out.println("1. Agregar chofer");
            System.out.println("2. Acciones de cliente");
            System.out.println("3. Acciones de chofer");
            System.out.println("4. Salir");
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        ruben.addDriver(createDriver());
                        break;
                    case 2:
                        Client client = createClient();
                        System.out.println("pedir viaje? (Si/No)");
                        if (sc.nextLine().toLowerCase().startsWith("s"))
                            askForTrip(client, ruben);
                        break;
                    case 3:
                        System.out.println("Elige un chofer");
                        ArrayList<Driver> drivers = ruben.getDrivers();
                        for (int i = 0; i < drivers.size(); i++)
                            System.out.println(i + ". " + drivers.get(i).getName());
                        int driverNumber = scanner.nextInt();
                        System.out.println("Menu de chofer: ");
                        System.out.println("chofer: " + drivers.get(driverNumber).getName());
                        String estado = "";
                        if (drivers.get(driverNumber).getOnline()) {
                            estado += "En linea";
                            if (drivers.get(driverNumber).getAvailable()) {
                                estado += " Y disponible";
                            } else estado += " Y ocupado";
                        }
                        if (!drivers.get(driverNumber).getOnline()) {
                            System.out.println("Estado: Desconectado");
                            System.out.println("Conectarse? Si/No");
                            if (sc.nextLine().toLowerCase().startsWith("s"))
                                drivers.get(driverNumber).goOnline();
                        }

                        System.out.println("Estado: " + estado);
                        break;
                    case 4:
                        on = false;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Opcion invalida");
                scanner.next();
            }
        }
    }

    private static Driver createDriver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del chofer: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese los datos del auto del chofer:");
        boolean hasSelectedCategory = false;
        String category = "Normal";
        while (!hasSelectedCategory){
        System.out.println("Categoria: ");
        System.out.println("1. Deluxe");
        System.out.println("2. Normal");
        System.out.println("3. Berreta");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        category = "Deluxe";
                        hasSelectedCategory = true;
                        break;
                    case 2:
                        category = "Normal";
                        hasSelectedCategory = true;
                        break;
                    case 3:
                        category = "Berreta";
                        hasSelectedCategory = true;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Opcion invalida");
                scanner.next();
            }
        }
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
        //implemento try catch vamos a ver si sale
        boolean choosing = true;
        long x = 0;
        long y = 0;
        while (choosing){
            try {
                x = scanner.nextLong();
                System.out.println("Ingrese la ubicacion del Cliente y:");
                y = scanner.nextLong();
                choosing = false;
            }
            catch(InputMismatchException exception){
                System.out.println("Opcion invalida");
                scanner.next();
            }
        }
        return new Client(new CreditCard(), new Location(x,y),name);
    }
    private static void askForTrip(Client client, rUBERn ruben){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los pasajeros: ");
        int passengers = 0;
        boolean choosing = true;
        while (choosing){
            try {
                passengers = scanner.nextInt();
                choosing = false;
            }
            catch(InputMismatchException exception){
                System.out.println("Opcion invalida");
                scanner.next();
            }
        }

        System.out.println("Ingrese el destino: ");
        System.out.println("X: ");
        Long destinationX = scanner.nextLong();
        System.out.println("Y: ");
        Long destinationY = scanner.nextLong();
        ruben.processRequest(client, new Location(destinationX,destinationY), passengers);
    }
}