package Lambdas;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UDU on 7/13/2017.
 */





class Asteroid{
    public String name;
    public double diameter;
    public Asteroid(String name, double diameter){
        this.name = "name";
        this.diameter=diameter;
    }

    public String toString (){
        return String.format("%s[%.2f]",this.name,this.diameter);
    }


}




public class Lambda2 {
    public static void main(String args[]){
        List<Asteroid> asteroids = new ArrayList<Asteroid>();
        asteroids.add(new Asteroid("asas",10));
        asteroids.add(new Asteroid("Lasas",100));
        Asteroid c = asteroids.stream().reduce(asteroids.get(0),(a,b)->a.diameter>b.diameter?a:b);
        System.out.println(c);


    }



}
