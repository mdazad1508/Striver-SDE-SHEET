public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
       
    */
    
    ArrayList<Node> list = new ArrayList<>();
    inorder(root,list);
    
    for(int i=0;i<list.size();i++){
        
        if(list.get(i).data == key){
            suc = i+1 <list.size()?list.get(i+1):null;
            pre = i-1 >=0?list.get(i-1):null;
             return;
        }else if(list.get(i).data > key){
            suc = list.get(i);
            pre = i-1 >=0?list.get(i-1):null;
            return;
        }
    }
    
    pre = list.get(list.size()-1);
    suc = null;
    
  }
  static void inorder(Node root, ArrayList<Node> list){
      
      if(root==null) return;
      
      inorder(root.left,list);
      list.add(root);
      inorder(root.right,list);
  }
}