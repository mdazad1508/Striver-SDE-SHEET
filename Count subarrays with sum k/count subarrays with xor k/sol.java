import java.io.*;
import java.util.* ;

import java.util.ArrayList;

// a^b = k
 // a^b^b = k^b
 // a=k^b;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {

		int count =0;
		HashMap<Integer,Integer> hmap = new HashMap<>();

        int xor =0;
		for(int i=0;i<arr.size();i++){

			xor = xor ^ arr.get(i);

			if(xor==x){
				count++;
			}

			int rem = xor^x ;  //- ke jagah xor
            
			if(hmap.containsKey(rem)){
				count += hmap.get(rem);
			}

			if(!hmap.containsKey(xor)){
				hmap.put(xor,1);
			}else{
				hmap.put(xor,hmap.get(xor) +1);
			}



		}

		return count;

	
	}
}