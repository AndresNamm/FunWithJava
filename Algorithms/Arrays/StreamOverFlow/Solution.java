public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] stream) {
        Long actualSum,correctSum,actualSum2,correctSum2, C1,C2, A,B;
        actualSum=correctSum=actualSum2=correctSum2=0L;

        for (int i =0; i<stream.length;i++){
            correctSum+= (long) i+1;
            correctSum2+= (long) (i+1)*(i+1);
            actualSum+= (long) stream [i];
            actualSum2+=(long) stream[i] *  stream[i];
        }

        C1=actualSum-correctSum;
        C2=correctSum2-actualSum2;

        B=Math.round(-C1/2.0 - C2/(2.0*C1));
        A= C1+B;
        return new int[]{Math.toIntExact(A),Math.toIntExact(B)};
    }
}


