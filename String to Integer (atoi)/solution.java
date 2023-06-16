class Solution {
    public int myAtoi(String s) {

        s= s.trim();
        if(s.length()==0){
            return 0;
        }

        int sign = s.charAt(0)=='-'?-1:1;
        
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            s= s.substring(1,s.length());
        }

        long num =0;

        char [] charArray = s.toCharArray();

        for(char letter : charArray){

            if(!Character.isDigit(letter)){
                break;
            }else{
                num = num *10 + letter -'0';
                if(sign*num >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(sign*num <= Integer.MIN_VALUE){
                      return Integer.MIN_VALUE;
                }
                
            }
        }
          return sign* (int)num;
        
        
    }
}