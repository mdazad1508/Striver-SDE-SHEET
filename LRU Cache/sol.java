class Node{
    Node next;
    Node prev;
    int val;
    int key;
    Node(int y,int x){
     this.val = x;
     this.next = null;
     this.prev = null;
     this.key = y;
    }
}

class LRUCache {

    HashMap<Integer,Node> hmap;
    Node head;
    Node tail;
    int size;
    int cap ;
    

    public LRUCache(int capacity) {

        hmap = new HashMap<>(capacity);
        head = new Node(-10,-10);
        tail = new Node(-10,-10);
        head.next = tail;
        tail.prev = head;
        size =0;
        cap = capacity;
        
    }
    
    public int get(int key) {

        if(hmap.containsKey(key)){
           
            Node curr =  hmap.get(key);
            //move this node to front of head;
            
            //deleting from that place
            Node currNext = curr.next;
            Node currPrev = curr.prev;
            currPrev.next = currNext;
            currNext.prev = currPrev;

            //putting in form of head;

            Node headNext = head.next;
            head.next = curr;
            curr.next = headNext;
            curr.prev = head;
            headNext.prev = curr;

            return curr.val;

        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        
        if(size == cap && !hmap.containsKey(key)){

            //Node before tail is LRU, delete it 
            Node del = tail.prev;
            Node delPrev = del.prev;
            delPrev.next = tail;
            tail.prev = delPrev;

            //also delete form hasmap

            hmap.remove(del.key);
            size--;

           
        }

       if(hmap.containsKey(key)){
           //update the value of node ;
           Node curr = hmap.get(key);
           curr.val = value;

            //deleting from that place
            Node currNext = curr.next;
            Node currPrev = curr.prev;
            currPrev.next = currNext;
            currNext.prev = currPrev;

            //putting in form of head;

            Node headNext = head.next;
            head.next = curr;
            curr.next = headNext;
            curr.prev = head;
            headNext.prev = curr;
       }else{

           Node newNode = new Node(key,value);
           //put it to the next of head;
           
           
            Node headNext = head.next;
            head.next = newNode;
            newNode.next = headNext;
            newNode.prev = head;
            headNext.prev = newNode;

            hmap.put(key,newNode);
            size++;

       }

       


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */