

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
        ArrayList<Integer> regular = new ArrayList<Integer>();
        Integer[] mkmk = (Integer[]) regular.toArray();
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
        // Comparator
        Collections.sort(regular);
        System.out.println(regular);
        Collections.sort(regular, new ArrayListComparator());
        System.out.println(regular);

        // FROM ARRAY TO LIST
        Integer[] k = new Integer[]{1, 23, 34};
        ArrayList<Integer> k1 = new ArrayList<Integer>(Arrays.asList(k));

        // ITERATOR
        // https://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/s
        Iterator<Integer> itr = k1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
            System.out.println(k1.size());
            //System.out.println(k1.);

        }
        k1 = new ArrayList<Integer>(Arrays.asList(k));
//WRONG
//        for(Integer i : k1){
//            k1.remove(i);
//            System.out.println(k1.size());
//
//        }

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
        Queue<Integer> k = new PriorityQueue<Integer>(10, new ArrayListComparator());
        Queue<String> sk = new PriorityQueue<String>(10);
        k.add(1);
        k.add(2);
        sk.add("212");

        //http://www.journaldev.com/1642/java-priority-queue-priorityqueue-example
        List<Integer> test = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            test.add((int) (Math.random()*1000));
        }

        Integer[] maximum = new Integer[]{-1, -1, -2};
        ArrayList<Integer> maxNumbers = new ArrayList<Integer>(Arrays.asList(maximum));
        Arrays.sort(maximum);
        for (Integer i : test) {
            if (i > maxNumbers.get(0)) {
                maxNumbers.set(0,i);
                Collections.sort(maxNumbers);
            }
        }

        PriorityQueue<Integer> max3 = new PriorityQueue<>(3);
        PriorityQueue<Integer> min3 = new PriorityQueue<>(3, Collections.reverseOrder());
        //PRETTY MUCHS HERE I COULD DEFINE SOME HEURISTIC LIKE IN HKU AI WITH THE COLLECTION

        for (int i = 0; i < 3; i++) {
            max3.add(test.get(i));
        }

        for (Integer i : test) {
            int temp = max3.peek();
            if (i > temp) {
                max3.poll();
                max3.offer(i);// IF SOME SIZE CONSTRAINT - NOT INITIALCAPACITY
            }
        }

        for (Integer i : test) {
            min3.offer(i);
            min3.add(i);
        }




        System.out.println("Three Largest in PriorityQueue" + max3);
        System.out.println("Three Largest in Array" + maxNumbers);

    }


    //HashSet


    public static void main(String[] args) {
        // write your code here

        Main k = new Main();
        //k.arrayListExample();
        //k.mapExamples();
        //k.arrayExamples();
        //k.stackExamples();
        //k.queueExamples();
        //k.linkedListExamples();

        k.priorityQueueExample();


    }
}
