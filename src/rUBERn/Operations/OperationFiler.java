package rUBERn.Operations;

import java.io.*;

/**
 * Created by arimirra on 20-Oct-16.
 */
public class OperationFiler {

    //tipos de archivo necesarios para que no se sobreescriba el archivo
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bw;
    private BufferedReader bf;
    private PrintWriter printWriter;

    //si bien le mando throws IOException estoy seguro que no va a pasar
    public OperationFiler() {
        try{
            file = new File("Operations.txt");
            fileWriter = new FileWriter(file, true);
            bw = new BufferedWriter(fileWriter);
            bf = new BufferedReader(new FileReader(file));
            printWriter = new PrintWriter(bw);
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
