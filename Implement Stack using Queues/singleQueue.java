class MyStack {

   Queue<Integer> q ;

    public MyStack() {
       
       q = new LinkedList<>();
        
    }
    
    public void push(int x) {
        
        q.add(x);
        
    }
    
    public int pop() {

        int size = q.size();

        for(int i=0;i<size-1;i++){
            int top = q.poll();

            q.add(top);
        }

        return q.poll();
      
        
    }
    
    public int top() {

        int size = q.size();

        for(int i=0;i<size-1;i++){
            int top = q.poll();

            q.add(top);
        }

        int ans = q.peek();
         q.poll();
         q.add(ans);

         return ans;

        
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */