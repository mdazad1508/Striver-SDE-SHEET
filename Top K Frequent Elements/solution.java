class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int freq;
        Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }

        @Override public int compareTo(Pair p2){
           return this.freq - p2.freq;  
            
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0) +1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }

        int [] ans= new int[k];
        for(int i=0;i<k;i++){
           ans[i] =pq.poll().val;
        }

        return ans;
    }
}