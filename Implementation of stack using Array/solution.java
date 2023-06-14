public class Main{
    public static void main(String[] args){
         
         Stack st = new Stack(5);
         st.push(1);
         st.push(2);
         st.push(3);
         st.push(4);
         st.push(5);
         System.out.println(st.peek());
         st.pop();
        System.out.println(st.peek());
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        
    }
}


 class Stack{
    int [] arr;
    int top;
    int cap;
    
    Stack(int x){
        arr = new int[x];
        top =-1;
        cap = x;
    }
    
    public void push (int x){
        
        if(isFull()){
            throw new StackOverflowError("stack is full");
        }
        
       top++;
       arr[top] = x;
    }
    
    public int pop (){
        
        if(isEmpty()){
           throw new StackOverflowError("stack is empty");
        }
        int val = arr[top];
        top--;
        return val;
    }
    
    public int peek(){
         if(isEmpty()){
           throw new StackOverflowError("stack is empty");
        }
        
        return arr[top];
    }
    
    public boolean isFull(){
        return top == cap-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    

}