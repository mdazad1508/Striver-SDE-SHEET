    public static void main(String[] args){
        
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.peek());
        q.poll();
        q.poll();
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        
    }
}


class Queue{
    int [] arr;
    int index;
    int cap;
    
    Queue(int x){
        arr= new int[x];
        index = -1;
        cap = x;
    }
    
    public void add(int x){
        
        if(index == cap-1){
            throw new StackOverflowError("queue is full");
        }
        
        index++;
        arr[index] = x;
    }
    
    public int poll(){
        
        if(index == -1){
            throw new StackOverflowError("queue is empty");
        }
        int val = arr[0];
        
        for(int i=0;i<index;i++){
            arr[i] = arr[i+1];
        }
        
        index--;
        
        return val;
        
    }
    
    public int peek(){
         if(index == -1){
            throw new StackOverflowError("queue is empty");
        }
        return arr[0];
    }
    
    public boolean isEmpty(){
        return index == -1;
    }
    
    public int size(){
        return index +1;
    }
}