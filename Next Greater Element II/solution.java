class Solution {
    public int[] nextGreaterElements(int[] nums) {
       
       //poora array ko phele hi stack me daal do ;
       //dhyan rakha hai ki stack me ulta array  bharna hai ...taki lastIndex at bottom and firstIndex at top; .... kyuki last wale ka comparision circular me phele first wale se hoga, so first wala top pe hona chaiye.

        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            st.add(nums[i]);
        }

        int [] ans = new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){

            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
                st.add(nums[i]);
            }else{
                ans[i] = st.peek();
                st.add(nums[i]);
            }
        }

        return ans;

        
    }
}