public class Heap {
    ArrayList<Integer> list = new ArrayList<>();
    
    public int left(int i){return 2*i +1;}
    public int right(int i){return 2*i + 2; }
    public int parent(int i){ return (i-1)/2 ;}

    public void add(int x){
        //step 1: add 
        list.add(x);

        int index = list.size()-1;

        //step 2: keep swapping parent and child till parent <= child
        while(list.get(index) < list.get(parent(index))){          //>(maxheap)
            swap(list,index,parent(index));
            index = parent(index);
        }
    }
    public int peek(){
        return list.get(0);
    }
    public int poll(){
        //step 1 : store data at index 0 (which is to be deleted);
        int data = list.get(0);

        //step2 :swap first with last element in list;
        swap(list,0,list.size()-1);

        //delete last element
        list.remove(list.size()-1);

        //heapify rest with root = 0;

        heapify(0);

        return data;
    }
    private void heapify(int i){
        //find minIndex among parent,leftchild and right child

       
        int minIndex = i;

        if(left(i) < list.size() && list.get(left(i))<list.get(minIndex)){  //(>max)
            minIndex = left(i);
        }
        if(right(i) < list.size() && list.get(right(i)) <list.get(minIndex)){ //>max
            minIndex = right(i);
        }

        // if minIndex is changed then swap them and call heapify on minIndex;

        if(minIndex != i){
            swap(list,minIndex,i);
            heapify(minIndex);
        }
    }
    public boolean isEmpty(){
        return list.size()==0;
    }

    static void swap(ArrayList<Integer> list , int a , int b){
        int temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }

    public static void main(String[] args){
        Heap h = new Heap();
        h.add(2);
        h.add(5);
        h.add(3);
        h.add(1);
        h.add(23);
        h.add(6);
        h.add(50);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.poll();
        }
    }
}