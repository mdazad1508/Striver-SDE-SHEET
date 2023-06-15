class MyStack {

   Queue<Integer> q1 ;
   Queue<Integer> q2;

   //ek time pe 1 queue hamesha khali rahega, 
   // ek se nikal se dusre me push karne ka concept;

    public MyStack() {
       
       q1 = new LinkedList<>();
       q2 = new LinkedList<>();
        
    }
    
    public void push(int x) {
        //ya phir dono empty hoga
        if(empty()){
            q1.add(x);
            return;
        }

        //ya dono me se koi ek hi empty hoga;


        if(!q1.isEmpty()){
            q1.add(x);
        }else if(!q2.isEmpty()){
            q2.add(x);
        }
        
    }
    
    public int pop() {

       if(!q1.isEmpty()){

           while(q1.size() !=1){

               q2.add(q1.poll());

           }
           return q1.poll();

       }else if(!q2.isEmpty()){

            while(q2.size() !=1){

               q1.add(q2.poll());

           }
           return q2.poll();
       }
      return -1;
    }
    
    public int top() {

         if(!q1.isEmpty()){

           while(q1.size() !=1){

               q2.add(q1.poll());

           }
           int ans = q1.peek();
           q2.add(q1.poll());
           return ans;

       }else if(!q2.isEmpty()){

            while(q2.size() !=1){

               q1.add(q2.poll());

           }
           int ans = q2.peek();
           q1.add(q2.poll());
           return ans;
       }
       return -1;
        
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
