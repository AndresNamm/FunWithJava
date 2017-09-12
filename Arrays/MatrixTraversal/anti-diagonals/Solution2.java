import java.util.ArrayList;

public class Solution {
    public int[][] diagonal(int[][] A) {
        ArrayList<Integer[]> startPoints= new ArrayList<>();
        // Generate startPoints to arraylist


        int lastRow =A.length-1;  // Last row nr
        int lastCol =A[0].length-1; // Last col nr
        int colBoundary=0;
        int rowBoundary=lastRow;
        int[][] ans = new int[lastRow+lastCol+1][];
        int rowStep = 1;
        int colStep = -1;
        // Alltogether we have to start from  lastRow + lastCol + 1 positions
        for (int i = 0; i<=lastRow+lastCol;i++ ){ // Allows lastcol+lastrow + 1 steps
            int startRow=i-lastCol>0 ? i-lastCol:0;
            int startCol=i < lastCol ? i : lastCol;
            // Start the steps form A[startRow][startCol]
            int diagSize= startCol-startRow + 1;  // 1, 2, 3, lastCol+1 , ... 1M
            //System.out.print(   startRow+  ";" + (startCol) + "| " );
            ans[i]=new int[diagSize];
            ans[i][0]=A[startRow][startCol];
            for(int j = 1; j < diagSize; j++){
                //System.out.print(   startRow+j*rowStep + ";" + (startCol+j*colStep) + "| " );
                ans[i][j]=A[startRow+j*rowStep][startCol+j*colStep];
                A[startRow+j*rowStep][startCol+j*colStep]=0;
            }
        }

        return ans;
    }


    public static void main(String args[]){
        Solution sol = new Solution();


        int[][] A = new int[][]{{1,1},{2,2}};

        int[][] ans =sol.diagonal(A);
        for(int[] k : ans){
            for(int s : k){
                System.out.print(s);
            }
            System.out.println();
        }

    }
}


