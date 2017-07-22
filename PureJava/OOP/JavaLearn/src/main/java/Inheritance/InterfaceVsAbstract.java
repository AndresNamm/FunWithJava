package Inheritance;

/**
 * Created by UDU on 7/22/2017.
 */
/**
 * Created by UDU on 7/20/2017.
 */

interface lamp{

    public int ide = 10;

    public default void printMe(){
        System.out.println(ide);
    }
}

abstract class lampabs{

    public int id = 10;
    public abstract void doSmt();
}



class lamp2 extends lampabs implements lamp {
    public void doSmt(){
        System.out.println(this.id);
    };

}

public class InterfaceVsAbstract {

    double[] k = new double[3];
    public static void main(String args[]){
        lampabs k = new lamp2();
        //k.printMe(); Cant use, because lampabs doesNodt hav this methos.
        /// /
        lamp x = new lamp2();
        //x.doSmt(); Cant use, because lamp does not have this method
        x.printMe();

        k.id=11;
        //k.ide=10; - cant change with interfaces.
    }
}
