package rUBERn;

// Created by nico on 10/3/16.

import java.util.ArrayList;
import Utils.Scanner;
import rUBERn.Exceptions.AlreadyInStatusException;
import rUBERn.Exceptions.InvalidStatusChangeException;

public class ConsoleCommunicator {
    private rUBERn ruben;
    public ConsoleCommunicator(rUBERn ruben){
        this.ruben = ruben;
    }

    public void consoleApp() throws AlreadyInStatusException, InvalidStatusChangeException {
        System.out.println("rUBERn");
        ArrayList<Client> clients = new ArrayList<>();
        boolean on = true;
        Scanner scanner = new Scanner();
        while (on) {
            System.out.println("Menu: ");
            System.out.println("1. Agregar chofer");
            System.out.println("2. Acciones de cliente");
            System.out.println("3. Acciones de chofer");
            System.out.println("4. Salir");

                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Ingrese el nombre del chofer: ");
                        String name = scanner.nextLine();
                        System.out.println("Ingrese los datos del auto del chofer:");
                        boolean hasSelectedCategory = false;
                        String category = "Normal";
                        while (!hasSelectedCategory) {
                            System.out.println("Categoria: ");
                            System.out.println("1. Deluxe");
                            System.out.println("2. Normal");
                            System.out.println("3. Berreta");
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
                        System.out.println("Ingrese la capacidad del auto: ");
                        int capacity = scanner.nextInt();
                        System.out.println("Ingrese la ubicacion del chofer x:");
                        long x = scanner.nextLong();
                        System.out.println("Ingrese la ubicacion del chofer y:");
                        long y = scanner.nextLong();
                        ruben.addDriver(new Driver(new CreditCard(), new Location(x, y), name, new Car(capacity, category)));
                        break;

                    case 2:
                        System.out.println("Ingrese el nombre del cliente: ");
                        String namec = scanner.nextLine();
                                System.out.println("Ingrese la ubicacion del Cliente x:");
                                Long clientPositionX = scanner.nextLong();
                                System.out.println("Ingrese la ubicacion del Cliente y:");
                                Long clientPositionY = scanner.nextLong();
                        Client client = new Client(new CreditCard(), new Location(clientPositionX, clientPositionY), namec);

                        System.out.println("pedir viaje? (Si/No)");
                        if (scanner.nextLine().toLowerCase().startsWith("s")) {
                            System.out.println("Ingrese los pasajeros: ");
                            int passengers = 0;
                            passengers = scanner.nextInt();
                            long destinationX = 0;
                            long destinationY = 0;
                            System.out.println("Ingrese el destino: ");
                            System.out.println("X: ");
                            destinationX = scanner.nextInt();
                            System.out.println("Y: ");
                            destinationY = scanner.nextLong();
                            client.request(new Location(destinationX, destinationY), passengers, ruben);
                            break;
                        }else
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
                        if (drivers.get(driverNumber).getStatus().toString().equals("Working"))
                            estado += "Trabajando";
                        if (drivers.get(driverNumber).getStatus().toString().equals("Online")){
                            estado += "En linea Y disponible";
                            System.out.println("Desconectarse? s/n");
                                if (scanner.nextLine().toLowerCase().startsWith("s"))
                                    drivers.get(driverNumber).goOffline();
                            }
                        if (drivers.get(driverNumber).getStatus().toString().equals("Offline")) {
                            System.out.println("Estado: Desconectado");
                            System.out.println("Conectarse? Si/No");
                            if (scanner.nextLine().toLowerCase().startsWith("s"))
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
    }
}