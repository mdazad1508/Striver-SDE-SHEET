

class MedianFinder{

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    //left me MaxHeap rahega 
    //right me minHeap rahega
    //left half ka maximun and right half ka minimun ka average median hoga;
    //left half jyda hua then median is maximun of left half;

    // arr[] = {1,2,3,4,5};   case odd
    //median = arr[(5-1)/2] = 2;
    //left half = {1,2,3}  and right half = {4,5};

     //a median is a number whose left(all less than equal to median) half count + 1 including him ==        right(all greater than median) half count without him in case of odd;

    // arr[] = {1,2,3,4,5,6}  case even;
    //median = arr[(6-1)/2] = 2;
    //left half = {1,2,3}  and right half = {4,5,6};

    //a median is a number whose left(all less than equal to median) half count including him ==   right      (all greater than median) half count without him in case of even 


    public MedianFinder() {
        
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
       
       if(maxHeap.size()==0 || num <= maxHeap.peek()){
           maxHeap.add(num);
       }else{
           minHeap.add(num);
       }

       //balancing (note maxHeap can have one extra elemenent than min heap but not less than min heap)

       if(maxHeap.size()-minHeap.size() > 1){
           minHeap.add(maxHeap.poll());
       }else if(maxHeap.size()-minHeap.size() <0){
           maxHeap.add(minHeap.poll());
       }
    }
    
    public double findMedian() {
        
       if(maxHeap.size() == minHeap.size()){
           //even
           return (maxHeap.peek() + minHeap.peek())/2.0f;
       }else{
           return maxHeap.peek();
       }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */