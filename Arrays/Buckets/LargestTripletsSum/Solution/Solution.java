class MinTop{
    Double[] max = new Double[]{-100.0,-100.0,-100.0};
    Double[] min = new Double[]{100.0,100.0,100.0};
    public MinTop(Queue<Double> minQ , Queue<Double> maxQ){
        int cnt=0;
        while(!maxQ.isEmpty()){
            this.max[cnt++]=maxQ.poll();
        }
        Arrays.sort(max,  Collections.reverseOrder());
        cnt=0;
        while(!minQ.isEmpty()){
            this.min[cnt++]=minQ.poll();
        }
        Arrays.sort(min);
    }
}

interface ExtremumTest{
    public boolean test(Double n1, Double n2);
}


public class Solution {
    
    public int solve(ArrayList<String> A){
        //Bucket generation
        ArrayList<PriorityQueue<Double>> buckets = new ArrayList<>();
        // Generate an Interval of queues.
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                buckets.add(new PriorityQueue<Double>(3, Collections.reverseOrder()));// TOP HIGHESET
            } else {
                buckets.add(new PriorityQueue<Double>(3)); // TOP LOWEST
            }
        }

        // PLace elements to their specific priorityQueuse
        for (String a : A) {
            double i = Math.abs(Double.valueOf(a));
            int placement = -1;
            if (i < (2.0 / 3.0)) {
                placement = 0;
            } else if (i < 1.0) {
                placement = 1;
            } else if (i < 2.0) {
                placement = 2;
            }

            if (placement != -1) {
                Queue<Double> bucket_min = buckets.get(placement * 2);// TOP HIGHEST
                Queue<Double> bucket_max = buckets.get(placement * 2 + 1); // TOP LOWEST
                tryPlaceToQueue(i, bucket_min, (Double n1, Double n2) -> n1 < n2);// COMPARES WITH TOP ELEMENT WHICH IS HIGHEST - MAX PRIOTRITYQUEUE
                //IF SMALLER THAN CURRENT LARGES=>REPLACE
                tryPlaceToQueue(i, bucket_max, (Double n1, Double n2) -> n1 > n2);


            }
        }

        MinTop a = new MinTop(buckets.get(0),buckets.get(1));
        MinTop b = new MinTop(buckets.get(2),buckets.get(3));
        MinTop c = new MinTop(buckets.get(4),buckets.get(5));
        double sum1,sum2,sum3,sum4,sum5;
        sum1 =a.max[0]+a.max[1]+ a.max[2];// THESE 3 ALLTOGETHER CANT BE > 2
        if(a.max[0]+a.max[1]<1.0){
            sum2=a.max[0]+a.max[1]+b.max[0];//if previous not in range, then this <2. fails only with sum2 < 1.0
        }else{// THIS MEANS THAT THERE ARE LESS THAN 3 ELEMENTS IN RANGE(0,2/3)
            sum2=a.max[0]+a.max[1]+b.min[0];
        }
        sum3=a.min[0]+b.min[0]+b.min[1];//if previous not in range,then this< 2
        sum4=a.min[0]+a.min[1]+c.min[0];
        sum5=a.min[0]+b.min[0]+c.min[0];



        if(inRange(sum1)|| inRange(sum2) ||inRange(sum3)||inRange(sum4)||inRange(sum5))
        {
            return 1;
        }
        return 0;
    }

    private boolean inRange(Double val){
        return (1.0 < val && val  < 2.0);
    }

    private void tryPlaceToQueue(Double value, Queue<Double> priority, ExtremumTest p) {
        if(priority.size()>2){ // DONT ALLOW THE QUEUE TO GROW TOO LARGE
            Double extremum = priority.peek();
            if (p.test(value, extremum)) {
                priority.poll();
                priority.offer(value);
            }
        }else{
            priority.offer(value);
        }
    }
}