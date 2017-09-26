import java.util.ArrayList;

public class Bucketing {


    ArrayList<ArrayList<Integer>> getBuckets(int sStart,int sEnd, int nrBuckets, int divisor){  // s- source , m- map ;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        //INITIALIZE BUCKETS
        for(int i=0; i < nrBuckets;i++){
            buckets.add(new ArrayList<>());
        }
        for(int i = sStart; i<=sEnd;i++){

            Double exactPosition = (Double.valueOf(i)/Double.valueOf(divisor)) * Double.valueOf(nrBuckets);
            int index =  (int) Math.floor(exactPosition);
            buckets.get(index).add(i);
            // THERE IS A DIFFRENCE, AT LEAST IN REGARD TO CASTING WITH primitive double and Number Double
            // This says what to do. https://stackoverflow.com/questions/9102318/cast-double-to-integer-in-java

        }

        return buckets;
    }




    public static void main(String[] args){

        Bucketing bucketing = new Bucketing();
        int divisor=23;
        int sStart = 0;
        int sEnd = 22;
        int nrBuckets = 5;


        System.out.println("Every bucket has to have Around " + Double.valueOf(sEnd-sStart+1)/Double.valueOf(5) +"ELements");
        ArrayList<ArrayList<Integer>> buckets =  bucketing.getBuckets(sStart,sEnd,nrBuckets,divisor);
        System.out.println("Printing out Bucket Historgam");
        for(ArrayList<Integer> bucket : buckets){
            System.out.println(bucket.size());
        }
        System.out.println("");
        System.out.println("Printing out Buckets");
        double cnt = 0;

        ArrayList<Double> differences = new ArrayList<>();
        Double prev = 0.0;
        for(ArrayList<Integer> bucket : buckets){
            System.out.print(bucket.size() + " "+ bucket);

            for( int i : bucket){

                differences.add(Double.valueOf(i)/Double.valueOf(divisor)*Double.valueOf(nrBuckets)-prev);
                System.out.print(Double.valueOf(i)/Double.valueOf(divisor)*Double.valueOf(nrBuckets)+"   ;");
                prev =Double.valueOf(i)/Double.valueOf(divisor)*Double.valueOf(nrBuckets);
            }
            System.out.println();
            cnt++;
        }
//
//        for(Double dif : differences){
//
//            System.out.println(dif);
//        }






    }


}
