class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> list = new ArrayList<>();
      
      if(root==null) return list;
      
      Node curr = root;
      Node curr2 = root;    //parallel right side left most;
      int loopCount =0;
      
      while(curr.left !=null || curr.right != null){
          list.add(curr.data);
          
          if(curr.left != null){
              curr = curr.left;
          }else{
              curr= curr.right;
          }
          
          loopCount++;
          
      }
      
      list.add(curr.data);
      boolean firstTime = true;
      
      //idea is to keep track of parallerally right subtree LEFT most node;
      
      while(loopCount !=0 && curr2 != null){
          
          if(firstTime){
              curr2 = curr2.right;
              firstTime = false;
          }else if(curr2.left != null){
              curr2= curr2.left;
          }else {
              curr2 = curr2.right;
          }
          
          loopCount--;
          
      }
      
      
      if(curr2 != null){
          
           while(curr2.left !=null || curr2.right != null){
          
              if(curr2.left != null){
              list.add(curr2.left.data);
              curr2 = curr2.left;
              }else{
              list.add(curr2.right.data);
              curr2 = curr2.right;
               }
             }
          
      }
     
      
      
      return list;
    }
}