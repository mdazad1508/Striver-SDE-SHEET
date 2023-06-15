import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.

		ArrayList<Integer> list =new ArrayList<>();

		while(!stack.isEmpty()){
			list.add(stack.pop());
		}

		Collections.sort(list);

		for(int i=0;i<list.size();i++){
			stack.push(list.get(i));
		}
	}

}