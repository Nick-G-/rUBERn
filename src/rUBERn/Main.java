package rUBERn;

import Utils.Scanner;

/**
 * Created by facundo on 10/19/16.
 */
public class Main {
    public static void main(String[] args) {
        Rubern rubern = new Rubern();
        Scanner scanner = new Scanner();
        System.out.println("Start GUI/Console");
        System.out.println("1. GUI");
        System.out.println("2. Console");
        int option = scanner.nextInt();
        if (option == 1){
            //Something along the lines of GUICommunicator gui = new GUICommunicator();
           //TODO: Implement GUI
        }else if (option == 2){
            ConsoleCommunicator console = new ConsoleCommunicator(rubern);
            console.consoleApp();
        }else{ System.out.println("Opcion Invalida");
        main(null);
        }
    }
}
