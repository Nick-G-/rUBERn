package Utils;

import java.util.InputMismatchException;

/**
 * Created by facundo on 10/19/16.
 */
public class Scanner {
    public Scanner(){
    }
    public int nextInt(){
        try{
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Opcion Invalida, Intentelo nuevamente");
            return nextInt();
        }
    }
    public String nextLine(){
        try{
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Opcion Invalida, Intentelo nuevamente");
            return nextLine();
        }

    }
    public Long nextLong(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        try{
            return scanner.nextLong();
        }catch (InputMismatchException e){
            System.out.println("Opcion Invalida, Intentelo nuevamente");
            return nextLong();
        }

    }
}
