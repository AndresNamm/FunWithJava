package com.company;

import javax.lang.model.element.Name;

public class Main {

// Thi
    //https://dzone.com/articles/java-copy-shallow-vs-deep-in-which-you-will-swim
    //reference copy vs object copy -  both shallow and deep copys are object copys
    public static void main(String[] args) {
	// write your code here

        //Immutable object cpy
        String k = " Teter";
        String c = k ;
        c= "jou";
        System.out.println(k);
        System.out.println(c);




    }
}
