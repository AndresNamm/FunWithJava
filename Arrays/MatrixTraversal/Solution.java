public class Solution {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    
	    int n = a.size();
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    initializeArray(result,2*(n-1)+1);// Just fill up the result array with empty arrays
	    // Antidiagonals from both sides of the centre antidiagonal
	    
	    
	    
	    // Add antidiagonals from the top half + the main antidiagonal
	    //  i range 0..n-1 <- all matrix columns
	    // Start place moves in columns with i from 0 to n-1 (first row last element)
	    for(int i=0; i<n;i++){
	        //rows grow, columns decline
	        for(int j=i;j>=0;j--){
	            (result.get(i)).add(a.get(i-j).get(j));
	        }
	    }
	   
	    //Add antidiagonals from the bottom half. 
	    // i range 0..n-2 <- all but the first matrix row. 
        // Start place moves in rows with n-1-i from n-1 to 1
	    for (int i=0; i<n-1;i++){
	        //rows grow, columns decline
	        for(int j=i; j>=0;j--){
	            (result.get(2*(n-1)-i)).add(a.get(n-1-j).get(n-1-(i-j)));
	        }
	    }  
	    return result;
	}
	
	
	
	
	
	public void initializeArray( ArrayList<ArrayList<Integer>> result, int n){
        for(int i = 0; i<n; i++){
            result.add(new ArrayList<Integer>());
        }
    }
}