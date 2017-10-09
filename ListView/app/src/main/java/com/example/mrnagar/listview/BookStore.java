package com.example.mrnagar.listview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Nagar on 16-09-2017.
 */
public class BookStore {
    public static List<Books> getBooks(){
        List<Books> books=new ArrayList<Books>();

        books.add(new Books("KALA KAGDA","KALI"));
        books.add(new Books("PILA PANI","PILALA"));
        books.add(new Books("PATTHAR","PATHAKAR"));
        books.add(new Books("ATASBAJI","CHAKERI"));
        books.add(new Books("KALA PANI","KAKA"));
        books.add(new Books("PIZZA","PINAKA"));
        books.add(new Books("HEROINE","H.K"));
        books.add(new Books("ATA GHUNA","CHAK-CHAK"));
        books.add(new Books("AKHADA","MUSCLE-MAN"));
        books.add(new Books("PANI PURI","PAPPU"));

        return books;
    }
}
