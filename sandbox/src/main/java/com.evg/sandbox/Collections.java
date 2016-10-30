package com.evg.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evg on 24.10.16.
 */
public class Collections {
    public static void main(String[] args){
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";

        String[] l = {"1", "a", "b", "ddd"};
        for(int i = 0; i< langs.length; i++){
            System.out.println("I want to " + langs[i]);
        }

        System.out.println("...");
        for (String i : l){
            System.out.println(" " + i);
        }
        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");

        System.out.println("...");
        for (String i : languages){
            System.out.println(" " + i);
        }
    }
}
