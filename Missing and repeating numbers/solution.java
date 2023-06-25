import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here

        int [] count = new int[n+1];

        for(int i=0;i<arr.size();i++){
            count[arr.get(i)]++;
        }

        int missing = -1;
        int repeating = -1;

        for(int i=1;i<count.length;i++){

            if(count[i]>1){
                repeating = i;
            }

            if(count[i]==0){
                missing = i;
            }
        }

        return new int[]{missing,repeating};
    }
}