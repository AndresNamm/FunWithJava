public class Solution {
	// DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> a) {

        int max, min, minGap,range;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;

        // 1. FIND MAXIMUM AND MINIMUM
        for(Integer i:a){
            max=Math.max(i,max);
            min=Math.min(i,min);
        }

        if(max-min==0){
            return 0;
        }


        range = a.size()-1; // IF RANGE IS SMALLER THAN N, IT IT PERFORMS SELECTION SORT.
        minGap= (int)Math.ceil((double)(max-min)/(range)); // There are altogether N-1 gaps between numbers in arrays.

        //2. BUILD UP DATASTRUTCTURE FOR STORING GAP INTERVAL MAX AND MIN VALUES
        int b1[] =new int[range];
        int b2[] =new int[range];
        
        Arrays.fill(b1,Integer.MAX_VALUE);
        Arrays.fill(b2,Integer.MIN_VALUE);

        // 3. FILL UP THIS DATASTRUCTURE
        for(Integer i:a){
            int position = (int) Math.floor((double)(i-min)/(max-min)*(range-0.0001));
            b1[position]= Math.min(i,b1[position]);
            b2[position]= Math.max(i,b2[position]);
        }

        // 4. LOOP OVER THE DATASTRUCTURE OF GAP SMALLEST AND LARGEST ELEMENTS.
        int i=0,j=0;
        while(i<range){
            if(b2[i]>0){
                for(j=i+1;j<range;j++) {
                    if (b2[j] > 0) {
                        minGap = Math.max(minGap, b1[j] - b2[i]);
                        break;
                    }
                }
                i = j;
            }else{
                i++;
            }
        }




        return minGap;

    }

}