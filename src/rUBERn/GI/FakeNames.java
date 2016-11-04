package rUBERn.GI;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by facundo on 11/3/16.
 */
public class FakeNames {
    private ArrayList<String> names;
    public FakeNames(){
        names = new ArrayList<>();
        names.add("Clinton");
        names.add("Bill");
        names.add("Herbert");
        names.add("Katrina");
        names.add("Edgar");
        names.add("Ruben");
        names.add("Peter");
        names.add("Alexander");
        names.add("Rick Astley");
        names.add("Robert");
        names.add("Jaimee");
        names.add("Herminia");
        names.add("Tera");
        names.add("Kena");
        names.add("Glady");
        names.add("Eliseo");
        names.add("Deangelo");
        names.add("Tammara");
        names.add("Suanne");
        names.add("Maryrose");
        names.add("Ash Ketchup");
        names.add("Belgrano");
        names.add("Pikachu Castaña");
    }
    public String getRandom(){
        return names.get(new Random().nextInt(names.size()));
    }
}
