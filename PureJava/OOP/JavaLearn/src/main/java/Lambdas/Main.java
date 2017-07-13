package Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    Main(GreetingService meetd){
        k = meetd;
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        sumAll(numbers, n -> true);
        sumAll(numbers, n -> n % 2 == 0);
        sumAll(numbers, n -> n > 3);
    }

    GreetingService k ;

    // Example obtained from here
    final static String salutation = "Hello! ";

    public int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");


        // Tester Part

        Main s  = new Main((string)->System.out.println(string));
        s.k.sayMessage("LAM");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
