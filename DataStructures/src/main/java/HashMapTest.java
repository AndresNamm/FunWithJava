package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public HashMapTest(){

    }

    public static void main(String[] args) {
        Map<Key, String> cityMap = new HashMap<Key, String>(4);
        cityMap.put(new Key(1, "NY"),"New York City" );
        cityMap.put(new Key(2, "ND"), "New Delhi");
        cityMap.put(new Key(3, "NW"), "Newark");
        cityMap.put(new Key(4, "NP"), "Newport");

        for(int i = 0; i<100; i++){
            cityMap.put(new Key(i ,"AbuDhabi"), "Summa");
        }

        System.out.println("size before iteration " + cityMap.size());
        Iterator<Key> itr;
        itr = cityMap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(cityMap.get(itr.next()));
        }
        System.out.println("size after iteration " + cityMap.size());
    }

}

// This class' object is used as key
// in the HashMap
class Key{
    int index;
    String Name;
    Key(int index, String Name){
        this.index = index;
        this.Name = Name;
    }

    @Override
    // A very bad implementation of hashcode
    // done here for illustrative purpose only
    public int hashCode(){
        return this.index%10;
    }

    @Override
    // A very bad implementation of equals
    // done here for illustrative purpose only
    public boolean equals(Object obj){
        return true;
    }
}