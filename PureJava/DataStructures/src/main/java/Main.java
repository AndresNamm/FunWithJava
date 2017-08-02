

import javax.print.attribute.IntegerSyntax;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    //ArrayList
    public class ArrayListComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 > i2 ? -1 : (i1 != i2) ? 1 : 0;
        }
    }

    public void arrayListExample() {

        //Regular Integer
        ArrayList<Integer> regular = new ArrayList<>();

        Integer[] mkmk =  regular.toArray(new Integer[regular.size()]);
        regular.add(1);
        regular.add(2);
        System.out.println(regular);
        regular.set(0, 10);
        System.out.println(regular);
        regular.remove(0);
        regular.remove(0);
        System.out.println(regular);

        regular.add(10);
        regular.add(2);
        //Comparator usage example
        Collections.sort(regular);
        System.out.println(regular);
        Collections.sort(regular, new ArrayListComparator());
        System.out.println(regular);
        Collections.sort(regular, Collections.reverseOrder());
        System.out.println("Reverseodre");
        System.out.println(regular);
        // FROM ARRAY TO LIST
        Integer[] k = new Integer[]{1, 23, 34};
        ArrayList<Integer> k1 = new ArrayList<>(Arrays.asList(k));

        // ITERATOR
        // https://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/s
        Iterator<Integer> itr = k1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
            System.out.println(k1.size());
            //System.out.println(k1.);

        }
        k1 = new ArrayList<>(Arrays.asList(k));
        //WRONG
//        for(Integer i : k1){
//            k1.remove(i);
//            System.out.println(k1.size());
//
//        }

        //jOIN 2 ARRAYLIST
        Integer[]arr = new Integer[]{8,9,10};
        ArrayList<Integer> listTva = new ArrayList<>(Arrays.asList(arr));
        k1.addAll((ArrayList<Integer>) listTva);
        System.out.println(k1);

    }


    //Maps
    public void mapExamples() {

        HashMap<Integer, Integer> ex = new HashMap<Integer, Integer>(4);
        for (int i = 0; i < 100; i++) {
            ex.put(i % 4, i * 100);
        }

        Iterator<Integer> itr = ex.keySet().iterator();
        while (itr.hasNext()) {
            System.out.println(ex.get(itr.next()));
        }
    }

    //Array

    // This is wrong, because primitive cant implement anything
//    public class ArrayComparator() implements Comparator<int>{
//
//    }
    public void arrayExamples() {
        Integer[] k = new Integer[10];
        Integer[] k2 = new Integer[]{1, 2, 3, 4};
        Arrays.sort(k);
        Arrays.sort(k2, new ArrayListComparator());
    }

    //Stack

    public void stackExamples() {

        Stack<Integer> k = new Stack<Integer>();
        k.push(1);
        k.push(2);
        while (!k.isEmpty()) {
            System.out.println(k.pop());
        }
        k.pop();
        k.peek();
        k.isEmpty();

    }


    //Linked lists have several advantages over arrays. Elements can be inserted into linked lists indefinitely,
    // while an array will eventually either fill up or need to be resized, an expensive operation that may not even
    // be possible if memory is fragmented.
    //Similarly, an array from which many elements are removed may become wastefully empty or need to be made smaller.
    //On the other hand, arrays allow random access, while linked lists allow only sequential access to elements.
    // Singly-linked lists, in fact, can only be traversed in one direction. This makes linked lists unsuitable for
    // applications where it's useful to look up an element by its index quickly, such as heapsort.
    // Sequential access on arrays is also faster than on
    // linked lists on many machines due to locality of reference and data caches. L
    // inked lists receive almost no benefit from the cache.
    //Linked List

    public void linkedListExamples() {
        LinkedList<Integer> k = new LinkedList<Integer>();
        k.add(1);
        k.add(2);
        k.remove(1);
        k.set(0, 10);
    }

    //Queue - USES A LINKED LIST

    public void queueExamples() {

        Queue<Integer> k = new LinkedList<>();
        k.add(1);
        k.add(2);
        while (!k.isEmpty()) {
            System.out.println(k.remove());
        }
        k.peek();
        k.isEmpty();

    }


    // PriorityQueue https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
    // Another tutorial https://stackoverflow.com/questions/683041/how-do-i-use-a-priorityqueue
    // http://www.journaldev.com/1642/java-priority-queue-priorityqueue-example


    public void priorityQueueExample() {

        Random generator = new Random(System.nanoTime());

        ArrayList<Integer> k = new ArrayList<>();
        for(int i = 0; i< 30; i++){
            k.add(generator.nextInt());
        }
        System.out.println(k);

        Queue<Integer> minQ = new PriorityQueue<>(); // minQ min is in top
        //Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer i : k){
            minQ.offer(i); // Some ways safer than add;// https://stackoverflow.com/questions/2703984/what-is-the-difference-between-the-add-and-offer-methods-in-a-queue-in-java
            //ADD - EXCPECTS TO BE ADDED
            // OFFER - IF NOT ADDED FOR SOME RESTRICITON RETURNS FALSE, - BETTER IN FLEXIBLE ENVIRONMENT
            //
        }

        k = new ArrayList<>();
        while(!minQ.isEmpty()){
            int s = minQ.poll();
            System.out.println(s);
        }
    }


    //HashSet


    public static void main(String[] args) {
        // write your code here

        Main k = new Main();
        k.arrayListExample();
        //k.mapExamples();
        //k.arrayExamples();
        //k.stackExamples();
        //k.queueExamples();
        //k.linkedListExamples();
        //k.priorityQueueExample();


    }
}
