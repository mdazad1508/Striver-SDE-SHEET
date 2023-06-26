class Solution {
    public List<Integer> majorityElement(int[] nums) {
     
      int n =nums.length;
      List<Integer> list = new ArrayList<>();

      //moore's voting algorithm : 

      // in n/2 there will be maximum 1 majority 
      // in n/3 there will be maximum 2 majority for ex n = 10 and n/3 = 3;

      int el1 = Integer.MIN_VALUE;
      int el2 = Integer.MIN_VALUE;
      int ct1 = 0;
      int ct2 = 0;


      for(int i=0;i<nums.length;i++){

          if(ct1==0 && el2 != nums[i]){        //never make same elements as maj1 and maj2;
              el1 = nums[i];
              ct1++;
          }else if(ct2==0 && el1 != nums[i]){
              el2 = nums[i];
              ct2++;
          }else if(nums[i]==el1){
              ct1++;
          }else if(nums[i]==el2){
              ct2++;
          }else{
              ct1--;
              ct2--;
          }
      }


      //checking if they are majority or not 

      ct1 = 0;
      ct2 =0;

      for(int i=0;i<nums.length;i++){
          if(el1==nums[i]) ct1++;
          if(el2==nums[i]) ct2++;
      }

      if(ct1 > n/3) list.add(el1);
      if(ct2> n/3) list.add(el2);
    
       
      return list;
        
    }
}