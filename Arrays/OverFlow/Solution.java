public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {

        long sum1,sum2,actual1, actual2 , C1, C2; 
        sum1 = sum2 = actual1 = actual2=0;
        int n = a.size();
	    int A,B;
	    
	    // Converts to long
	    for(int i = 0; i<n; i++){
	        sum1 += (long) (i+1);
	        sum2 += (long) (i+1) * (long) (i+1);
	        actual1 += (long) a.get(i);
	        actual2 += (long) a.get(i)* (long) a.get(i);
	        
	    }
	    
	    
	    C1 = actual1-sum1; // Annab longi
	    C2 = actual2-sum2;// Annab longi
	    
	    
	    
	    // Performs operations with long and then returns result in integer form .
	    B = Math.toIntExact( Math.round(  (C2/(2.0*C1)) - (C1/2.0)    ));
	    A = Math.toIntExact(C1+B );
	    //  sum1-B+A=actual1
	    //  sum2-(B)**2 +(A)**2=actual2;
	    //  A = actual1 + B - sum1
	    //  B  = (actual2-sum2-(actual1-sum1)**2)/(actual1-sum1)*2
	   
	    
	    ArrayList<Integer> answer = new ArrayList<Integer>();
	    answer.add(A);
	    answer.add(B);
	    return answer;
	    
	    
	}
}