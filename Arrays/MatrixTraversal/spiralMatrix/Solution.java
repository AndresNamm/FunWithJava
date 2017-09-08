import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        // Oletame, et elemendid on olemas
        int n2 = (int) Math.pow(n, 2);
        int[][] nn = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
 
        int cDir, cnt;
        cnt =  1;
        // Lisan 1 rea
        for (int i = 0; i < n; i++) {
            cnt++;
            nn[0][i] = i + 1;
        }
        // Esimene positsioon 1 rida (0-st alustades) ja n-1 veerg
        int[] pos = {0, n - 1};
        cDir = 1;
        for (int i = n - 1; i > 0; i--) {// Nr of steps  
            for (int j = 0; j < 2; j++) { // How many time we do these steps 
                for (int l = 0; l < i; l++) {
                    pos[0] += dir[cDir][0];
                    pos[1] += dir[cDir][1];
                    nn[pos[0]][pos[1]] = cnt;
                    // Change in this position
                    // Give into this direction
 
                    // Update position and number
                    cnt++;
                }
                //change direction
                cDir += 1;
                cDir %= 4;
            }
 
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<n; i++){
            ans.add(new ArrayList<Integer>());
            for(int j= 0; j<n; j++){
                ans.get(i).add(nn[i][j]);
            }
        }
        return ans;
    }


    public static void main(String args[]) {
        // Create 1 row .
        // Start procedure, where
        // For i = n-1 .. 1
        // choose direction based on total count % 4
        // For j = 2
        // For 1..i
        // move to next position with directional step , assign count

        Solution sol = new Solution();
        System.out.println(sol.generateMatrix(10));
    }


}
