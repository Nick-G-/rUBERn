package rUBERn;

// Created by nico on 10/1/16.

import java.util.HashMap;

public class CategoriesCatalogue {
    private HashMap<String,Integer> catalogue; //catalogue as "Category" "percentage (int)"
    public CategoriesCatalogue(HashMap<String, Integer> catalogue){
        this.catalogue = catalogue;
    }
    public int getPercentage(String category){
    return catalogue.get(category);
    }
}
