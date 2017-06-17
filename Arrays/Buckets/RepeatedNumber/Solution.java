import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;




/**
 * Created by UDU on 5/21/2017.
 */



public class Solution {


    public int repeatedNumber(final List<Integer> a) {
        // Wa have an array of numbers between 1 and n and array of size n+1
        double n = a.size()-1;
        int  sqrtN= (int) Math.floor((Math.sqrt(n)));
        int[] counter = new int[(int) Math.floor(sqrtN)]; // counted into floor(sqrtN) pieces
        int t=0;



        for(int i : a){
            counter[(int) (Math.floor(sqrtN/n*i)<sqrtN ? Math.floor(sqrtN/n*i):sqrtN-1)]++; // This function divides 0..n to 0..sqrtN proportionally
        }


        int range[] = new int[]{-1,-1};
        for(int i =0;i<counter.length;i++){
            if(counter[i]>(n)/sqrtN){ // Potential candidate - cant happen too many times.
                range[0]= (int) Math.floor(i/sqrtN*n);
                range[1]=(int) ( Math.ceil((i+1)/sqrtN*n)< n ? Math.ceil((i+1)/sqrtN*n) :  n);
                HashMap<Integer,Integer> ans = new HashMap<Integer,Integer>();
                for(int j:a){
                    if(j>=range[0] && j<=range[1]){
                        Integer freq = ans.get(j);
                        ans.put(j, (freq == null) ? 1 : freq + 1);
                        if(ans.get(j)>1){
                            return j;
                        }
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        ArrayList<Integer> k = new ArrayList<Integer>();
        for(int i =2; i<10; i++){
            k.add(i);
            if(i%3==0){
                k.add(i);
            }
        }

        Integer[] sum = new Integer[]{ 247, 240, 303, 9, 304, 105, 44, 204, 291, 26, 242, 2, 358, 264, 176, 289, 196, 329, 189, 102, 45, 111, 115, 339, 74, 200, 34, 201, 215, 173, 107, 141, 71, 125, 6, 241, 275, 88, 91, 58, 171, 346, 219, 238, 246, 10, 118, 163, 287, 179, 123, 348, 283, 313, 226, 324, 203, 323, 28, 251, 69, 311, 330, 316, 320, 312, 50, 157, 342, 12, 253, 180, 112, 90, 16, 288, 213, 273, 57, 243, 42, 168, 55, 144, 131, 38, 317, 194, 355, 254, 202, 351, 62, 80, 134, 321, 31, 127, 232, 67, 22, 124, 271, 231, 162, 172, 52, 228, 87, 174, 307, 36, 148, 302, 198, 24, 338, 276, 327, 150, 110, 188, 309, 354, 190, 265, 3, 108, 218, 164, 145, 285, 99, 60, 286, 103, 119, 29, 75, 212, 290, 301, 151, 17, 147, 94, 138, 272, 279, 222, 315, 116, 262, 1, 334, 41, 54, 208, 139, 332, 89, 18, 233, 268, 7, 214, 20, 46, 326, 298, 101, 47, 236, 216, 359, 161, 350, 5, 49, 122, 345, 269, 73, 76, 221, 280, 322, 149, 318, 135, 234, 82, 120, 335, 98, 274, 182, 129, 106, 248, 64, 121, 258, 113, 349, 167, 192, 356, 51, 166, 77, 297, 39, 305, 260, 14, 63, 165, 85, 224, 19, 27, 177, 344, 33, 259, 292, 100, 43, 314, 170, 97, 4, 78, 310, 61, 328, 199, 255, 159, 185, 261, 229, 11, 295, 353, 186, 325, 79, 142, 223, 211, 152, 266, 48, 347, 21, 169, 65, 140, 83, 156, 340, 56, 220, 130, 117, 143, 277, 235, 59, 205, 153, 352, 300, 114, 84, 183, 333, 230, 197, 336, 244, 195, 37, 23, 206, 86, 15, 187, 181, 308, 109, 293, 128, 66, 270, 209, 158, 32, 25, 227, 191, 35, 40, 13, 175, 146, 299, 207, 217, 281, 30, 357, 184, 133, 245, 284, 343, 53, 210, 306, 136, 132, 239, 155, 73, 193, 278, 257, 126, 331, 294, 250, 252, 263, 92, 267, 282, 72, 95, 337, 154, 319, 341, 70, 81, 68, 160, 8, 249, 96, 104, 137, 256, 93, 178, 296, 225, 237 };
        ArrayList<Integer> z = new ArrayList<Integer>(Arrays.asList(sum));
        Solution ans = new Solution();
        System.out.println(ans.repeatedNumber(z));


    }
}








