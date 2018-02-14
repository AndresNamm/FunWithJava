public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        long cor, ac, cor2, ac2;
        cor=ac=cor2=ac2=0;
        for(int i =0  ; i<A.length; i++){
            cor+=(long)i+1;
            ac+=(long) A[i];
            cor2+=(long)(i+1)* (long)(i+1);
            ac2+= (long) A[i]* (long) A[i];
        }
        long a,b, c1, c2; 
        c1 = ac - cor; 
        c2 = ac2 -cor2;
  	// Here we discussed that division in the form
	// long/long or int/int to save precision should be done 
        // by converting one of the members of division to double first
        // example like this: long/(double) long
	b= Math.round((c2-c1*c1)/(2*(double)c1));
        a = c1+b;
        int ans[] ={Math.toIntExact(a),Math.toIntExact(b)};
        return ans; 
    }
}
