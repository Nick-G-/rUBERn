package rUBERn;

import java.util.Scanner;

/**
 * Created by facundo on 10/13/16.
 */
public class ServerSide {

    public static void main(String[] args) {
        System.out.println("rUBERn");
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        while(on){
            System.out.println("Menu: ");
            System.out.println("1. Dar de alta chofer");
            System.out.println("2. Salir");
            switch (scanner.nextInt()){
                case 1: createDriver();
                case 2: on = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
    private static void createDriver(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del chofer: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese los datos del auto del chofer:");
        System.out.println("Categoria: ");
        String category = scanner.nextLine();
        System.out.println("Ingrese la capacidad del auto: ");
        int capacity = scanner.nextInt();
        Driver driver = new Driver(name, new Car(capacity,category));
        //// TODO: 10/13/16 Add driver to persistent file
    }
}
