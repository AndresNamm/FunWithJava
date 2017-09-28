public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        ArrayList<Integer> min = new ArrayList(A.length);
        ArrayList<Integer> max = new ArrayList(A.length);

        int maxNr = A[A.length-1];
        int minNr = A[0];

        int i, j; 
        for(i = 0; i<A.length; i++){
            j = A.length-1-i; 
            maxNr = maxNr>A[j]?maxNr:A[j];
            max.add(0,maxNr);
            minNr = minNr<A[i]?minNr:A[i];
            min.add(minNr);
        }
        
        // As j grows, the max array (values A[j]) gets smaller
        // As i grows, the min array (values A[i]) gets smaller as well 
        // We are trying to find max j-i with condition A[j]>=A[i]
        i=j=0; 
        int maxDif=-1;
        while(i<min.size() && j < max.size()){
            if(min.get(i)<=max.get(j)){
                maxDif = Math.max(maxDif,j-i);
                j++;
            }else{
                i++;
            }
        }
        
        return maxDif;
    }
}
