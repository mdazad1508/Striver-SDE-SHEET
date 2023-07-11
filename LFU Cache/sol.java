class Node{
    int key;
    int val ;
    int freq;
    Node next;
    Node prev;
    Node(int x, int y){
        this.key = x;
        this.val = y;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }
}

class DLL{
    Node head;
    Node tail ;
    int size;

    DLL(){
      head = new Node(-10,-1);
      tail = new Node(-15,-1);
      head.next = tail;
      tail.prev = head;
      size =0;
    }

    void addNextToHead(Node curr){
            Node headNext = head.next;
            head.next = curr;
            curr.next = headNext;
            curr.prev = head;
            headNext.prev = curr;
            size++;
    }

    void deleteNode(Node curr){
            Node currNext = curr.next;
            Node currPrev = curr.prev;
            currPrev.next = currNext;
            currNext.prev = currPrev;
            size--;
    }

}



class LFUCache {

    HashMap<Integer,Node> keyToNode;
    HashMap<Integer,DLL> freqToList;
    int size;  //keyToNode ka size 
    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
        size=0;
        cap = capacity;
        minFreq = -1;
    }
    
    public int get(int key) {

        if(keyToNode.containsKey(key)){

            Node node = keyToNode.get(key);
            update(node);
            return node.val;
            
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        
       if(cap ==0) return;

       if(keyToNode.containsKey(key)){
          
          Node curr  = keyToNode.get(key);
          curr.val = value;
          update(curr);
       }else{

           if(size==cap){
               //delete LFU 
               DLL list = freqToList.get(minFreq);
               Node del = list.tail.prev;
               list.deleteNode(del);

               keyToNode.remove(del.key);
               size--;
           }
         
       minFreq = 1;
       Node newNode = new Node(key,value);
       keyToNode.put(key,newNode);

       DLL currDLL = freqToList.getOrDefault(minFreq,new DLL());
       currDLL.addNextToHead(newNode);

       freqToList.put(newNode.freq,currDLL);
       size++;
       }

       

    }
    private void update(Node node){

            DLL currDLL = freqToList.get(node.freq);

            currDLL.deleteNode(node);

            if(node.freq == minFreq && currDLL.size==0){
                //increase the minFreq;
                minFreq++;
            }

            node.freq++;

            DLL nextDLL = freqToList.getOrDefault(node.freq,new DLL());
            nextDLL.addNextToHead(node);

            freqToList.put(node.freq,nextDLL);

       }
}