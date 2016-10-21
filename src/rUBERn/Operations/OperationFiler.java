package rUBERn.Operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Created by arimirra on 20-Oct-16.
 */
public class OperationFiler {

    //tipos de archivo necesarios para que no se sobreescriba el archivo
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter buffer;
    private PrintWriter printWriter;

    //si bien le mando throws IOException estoy seguro que no va a pasar
    public OperationFiler() {
        try{
            file = new File("Operations.txt");
            fileWriter = new FileWriter(file, true);
            buffer = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(buffer);
        }
        catch (IOException e){
            throw new RuntimeException("no lee", e);
        }
    }

    public void FileOperation(String operationData){
        printWriter.println(operationData);
        printWriter.println();
        printWriter.close();
    }

    public File getFile(){
        return file;
    }

}
