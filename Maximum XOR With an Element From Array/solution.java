class Solution {

    class QueryComparator implements Comparator<int[] >{

        @Override
        public int compare(int [] arr1, int []arr2){
            return arr1[1] - arr2[1];
        }

    }
    public int[] maximizeXor(int[] nums, int[][] queries) {


        Trie root = new Trie();

        int [][] offlineQuery = new int[queries.length][3];   //1 extra for storing index;

        for(int i=0;i<queries.length;i++){

            offlineQuery[i][0] = queries[i][0];   // num
            offlineQuery[i][1] = queries[i][1];    //limit;
            offlineQuery[i][2] = i;                //index;
        }


        Arrays.sort(offlineQuery,new QueryComparator());
        //Arrays.sort(offlineQuery,(o1,o2)->o1[1]-o2[1]);
        Arrays.sort(nums);
        
        int ans[] = new int[queries.length];
        int index =0;
        for(int i=0;i<offlineQuery.length;i++){

            while(index < nums.length && nums[index] <= offlineQuery[i][1]){
                root.insert(nums[index]);
                index++;
            }

            if(index==0){
                //no element less found 
               ans[offlineQuery[i][2]] = -1;
            }else{
                ans[offlineQuery[i][2]] = root.getMax(offlineQuery[i][0]);
            }

        }

        return ans;


       
    }
}

class Trie{
    Trie bits[];
    int endValue;

    Trie(){
        bits = new Trie[2];
        
    }

    void insert(int nums){
        Trie curr = this;
        for(int i=31;i>=0;i--){
            int bit = (nums>>i) & 1;

            if(curr.bits[bit]==null){
                curr.bits[bit] = new Trie();
            }

            curr = curr.bits[bit];
        }
        
    }

    int getMax(int nums){
        
        Trie curr = this;
        int ans =0;
        for(int i=31;i>=0;i--){

            int bit = (nums>>i) & 1;

            if(curr.bits[1-bit] != null){
                ans = ans | (1<<i);
                curr = curr.bits[1-bit];
            }else{
                curr = curr.bits[bit];
            }
        }

           return ans;
       
        
    }
}