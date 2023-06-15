class Solution {
    public int romanToInt(String s) {
        
        
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        
     int sum =0;

     for(int i =0; i<s.length(); i++){

            if(s.charAt(i)=='M'){
                sum =sum+1000;
            }else if(s.charAt(i)=='D'){
                sum=sum+500;
            }else if(s.charAt(i)=='C'){
                sum = sum +100;
            }else if(s.charAt(i)=='L'){
                sum = sum +50;    
            }else if (s.charAt(i)=='X'){
                sum =sum + 10;
            }else if (s.charAt(i)=='V'){
                sum =sum + 5;   
            }else if(s.charAt(i)=='I'){
                sum = sum +1;
            }

        }

        return sum;

        
    }
    
}