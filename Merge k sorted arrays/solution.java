import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> list, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();


		for(int i=0;i<list.size();i++){

			for(int j=0;j<list.get(i).size();j++){
				pq.add(list.get(i).get(j));
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while(!pq.isEmpty()){
			ans.add(pq.poll());
		}

		return ans;


	}
}