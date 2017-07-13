package Inheritance;
import java.util.ArrayList;

/**
 * Created by UDU on 7/13/2017.
 */

class Paren{
    String val ="pARNET";
    public String getVal(){
        return val;
    }
}


class Child extends Paren{
    String val ="Child";
    public String getVal(){
        return val;
    }
}


public class Test {



    public static void main(String[] args) {

        Paren child=  new Child();
        System.out.println(child.getVal() +" "+child.val);



    }

}


//