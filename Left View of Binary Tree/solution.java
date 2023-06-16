
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ds = new ArrayList<>();
      
      fun(root,0,ds);
      return ds;
      
      //preorder traversal
    }
    static void fun(Node root, int level , ArrayList<Integer> ds){
        
        if(root==null){
            return;
        }
        
        if(level==ds.size()){
            ds.add(root.data);
        }
        
        fun(root.left,level+1,ds);
        fun(root.right,level+1,ds);
    }
}


//level order traversal 

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ds = new ArrayList<>();
      
      if(root==null) return ds;
      fun(root,ds);
      return ds;
      
      //level order traversal
    }
    static void fun(Node root , ArrayList<Integer> ds){
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i=0;i<count;i++){
                
               Node curr = q.poll();
               if(i==0){
                   ds.add(curr.data);
               }
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        
        
    }



//NOT RECOMMMENDED VERY LENGTHY


/* 
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
} */