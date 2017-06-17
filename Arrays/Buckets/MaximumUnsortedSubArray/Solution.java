public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>(); 
        int mR,mL,j;
        mR=mL=-1;
        
        // Find a failure from Left and Right side of the array
        for(int i = 1; i<A.size(); i++){
            j=A.size()-i;
            if(A.get(i)<A.get(i-1) & mL==-1){
                mL = i-1;
            }
            if(A.get(j)<A.get(j-1) & mR==-1){
                mR = j; 
            }
        }
        
        if(mR==-1){// In case o failure found, return -1
            ans.add(-1);
            return ans;
        }
        int maxUnsort = Integer.MIN_VALUE;
        int minUnsort = Integer.MAX_VALUE; 
        
        //Find the largest  and smallest number in between the failure smubarray
        for(int i = mL; i<=mR; i++){
            maxUnsort=Math.max(maxUnsort, A.get(i));
            minUnsort=Math.min(minUnsort, A.get(i));
        }
       
		// Find the actual position of the largest and smallest elements. 
	   
        int ansL=0;
        int ansR=A.size()-1;
       		
	   for(int i = 0; i<mL; i++){
            if(A.get(i)<=minUnsort){
                ansL++;
            }
        }
        
        for(int i=0; i<A.size()-mR-1; i++ ){
             if(A.get(A.size()-1-i)>=maxUnsort){
                ansR--;
            }
        }
        
        
        ans.add(ansL);
        ans.add(ansR);
        return ans;
        
    }
}
