class Solution {
    public int findMaximumXOR(int[] nums) {
        

        Trie root = new Trie();

        //insert all numbers
        for(int i=0;i<nums.length;i++){
           root.insert(nums[i]);
        }

        int ans =0;

        //find maximum xor for each number;
        for(int i=0;i<nums.length;i++){

            ans = Math.max(ans,root.getMax(nums[i]));
        }
        
        return ans;
       
    }
}


class Trie{
    Trie[] bits;

    Trie(){
        bits = new Trie[2];
    }

    void insert(int num){

        Trie curr = this;

        for(int i=31;i>=0;i--){

           int bit = ((num>>i) & 1);
            
            if(curr.bits[bit]==null){
                curr.bits[bit] = new Trie();
            }

            curr = curr.bits[bit];
        }
    }

    int getMax(int num){

        Trie curr = this;
        int ans=0;
        for(int i=31;i>=0;i--){

            int bit = (num>>i) & 1;

            if(curr.bits[1-bit] !=null){
        //if opposite is present,means my answer will contain set bit at that position bcz 1^0 =1 and 0^1=1
                ans = ans | (1<<i);
                curr = curr.bits[1-bit];
            }else{
      //opposite is not present, means we will have to take same bit (0^0 =0 and 1^1=0ie originally 0);
      //also ans will originally have 0 at that bit , so no need to change;
                curr = curr.bits[bit];
            }
        }

        return ans;
    }
}