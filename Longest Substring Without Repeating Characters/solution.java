class Solution {
    public int lengthOfLongestSubstring(String s) {

      //sliding window 

      HashMap<Character,Integer> hmap= new HashMap<>();

      int left = 0 ;
      int right =0;

     int  maxLength = 0;

      while(right < s.length()){
          
          char letter = s.charAt(right);

          if(hmap.containsKey(letter)){
              //update left and left should not decrease cz of some element which got skipped and their 
              //index is before left , ex abccab

              int nextLeftIndex = hmap.get(letter)+1;

              if(nextLeftIndex > left) left = nextLeftIndex;

          }
           
          hmap.put(letter,right);
          maxLength = Math.max(maxLength,right-left+1);
          right++;

      }

      return maxLength;
        
    }
}