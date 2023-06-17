import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
	static class Pair{
		int num;
		BinaryTreeNode<Integer> node;

		Pair(int num , BinaryTreeNode<Integer> node){
			this.num= num;
			this.node = node;
		}
	}
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
      
	//num ==1 (preorder (Root:1 ,left ,right)) -> num ++ , if left!= null,add left to stack(after root is left)
	//num ==2 (inorder (left,Root:2,right)) -> num ++ , if right!= null,add right to stack (after root is right)
    //num ==3 (postorder(left,right,Root:3)) -> num is at max,no increment,
	//next of root is nothing so Remove this from stack(stack must have went throught all values of num ie 1,2 before reaching 3)
     
	 List<Integer> list1 = new ArrayList<>();
     List<Integer> list2 = new ArrayList<>();
	 List<Integer> list3 = new ArrayList<>();
	 List<List<Integer>> list = new ArrayList<>();

	 if(root==null) return list;

	 Stack<Pair> st = new Stack<>();


	 st.push(new Pair(1,root));

	 while(!st.isEmpty()){

		 Pair curr = st.pop();
		 int num = curr.num;

		 if(num==1){
			 //preorder
			list1.add(curr.node.data);
			curr.num++;
			st.push(curr); //you need to push it back again to update the value in stack

			if(curr.node.left != null){
				st.push(new Pair(1,curr.node.left));  //vigin node that's why 1
			}
			 
		 }else if(num==2){
			 //inorder

			 list2.add(curr.node.data);
			 curr.num++;
			 st.push(curr);

             
			if(curr.node.right != null){
				st.push(new Pair(1,curr.node.right)); //virgin node that's why 1
			}



		 }else{
			 //postorder
			 list3.add(curr.node.data);
			 //don't push it back again;
			 //since no increment of num is possible;
			 //no left right

		 }

	 }

	 
	 list.add(new ArrayList<>(list2));
	 list.add(new ArrayList<>(list1));
	 list.add(new ArrayList<>(list3));


	 return list;

	}

}