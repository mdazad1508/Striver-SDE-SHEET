class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    //pop and peek is ke liye s2 me transfer kar ke ans nikal ke wapis s1 me daal denge;

    public MyQueue() {
     s1 = new Stack<>();
     s2 = new Stack<>();
        
    }
    
    public void push(int x) {
        s1.push(x);
        
    }
    
    public int pop() {
       
       while(s1.size() != 0){
           s2.add(s1.pop());
       }

       int ans = s2.pop();

       while(s2.size() != 0){
           s1.add(s2.pop());
       }
      
      return ans;
        
    }
    
    public int peek() {

     while(s1.size() != 0){
           s2.add(s1.pop());
       }

       int ans = s2.peek();

       while(s2.size() != 0){
           s1.add(s2.pop());
       }
      
      return ans;
        
    }
    
    public boolean empty() {

        return s1.isEmpty() && s2.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */