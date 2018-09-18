import java.util.ArrayList;

public class Solution {


    public int[][] generateMatrix(int A) {
        int [][] ans = new int[A][A];
        int[] pos = new int[]{0,0};

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int currentDirection = 0;
        int stance = 1;
        int placesToMark=A;
        int placesMarked=0;
        for (int i = 0; i<A*A; i++) { // this for loop is kinda explained on the picture "concept.jpg"
            ans[pos[0]][pos[1]]=i+1;
            placesMarked+=1;
            if(placesMarked==placesToMark){
                currentDirection=(currentDirection+1)%4;
                stance=(stance+1)%2;
                placesMarked=0;
                if(stance==0){
                    placesToMark-=1;
                }
            }
            pos[0] += directions[currentDirection][0];
            pos[1] += directions[currentDirection][1];
        }
        return ans;
    }

    public int[][] antiDiagonal(int[][] A) {
        int[][] ans = new int[A.length*2-1][];
        int[][] directions = {{0,1},{1,0}};
        int[] startPos = new int[]{0,0};
        int curDir = 0;

        for(int i =0; i<A.length*2-1;i++){

            ArrayList<Integer> temp = new ArrayList<>();

            int[] pos = startPos.clone();
            //System.out.println(String.format("Startposition Y=%d,X=%d ", pos[0],pos[1]));
            while(pos[1]>=0 && pos[0]<A.length){
                temp.add(A[pos[0]][pos[1]]);
                pos[0]+=1;
                pos[1]-=1;
            }

            ans[i] = temp.stream().mapToInt(j->j).toArray();

            if(i==A.length-1){
                curDir+=1;
            }

            startPos[0]+=directions[curDir][0];
            startPos[1]+=directions[curDir][1];
        }
        return ans;
    }


    public void matrixPrinter(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%d ",matrix[i][j]));
            }
            System.out.println();
        }

    }


    public static void main(String args[]) {
        int A = 10;
        Solution sol = new Solution();
        int[][] matrix = sol.generateMatrix(A);
        System.out.println(String.format("Spiral of matrix w. size %d",A));
        sol.matrixPrinter(matrix);
        int[][] antiDiagonal = sol.antiDiagonal(matrix);
        System.out.println(String.format("Anti Diagonals of the spiral matrix w. size %d",A));
        sol.matrixPrinter(antiDiagonal);
    }

}
