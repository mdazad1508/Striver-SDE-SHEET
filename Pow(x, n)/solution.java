/*  pow(x,n)  if n: even  => x=x*x and n=n/2 ex 2^4 == (2**2)^2   
 if n:odd  ans = ans*x and n--    ex 2^3 , ans = ans*2 and n-- ie  */

 class Solution {
    public double myPow(double x, int n) {


      long p = n;
      if(p<0) p = -1 * p;

      double ans = 1.0;
      while(p != 0){

          if(p%2==0){
              x = x*x;
              p= p/2;
          }else{
              ans = ans * x;
              p = p-1;
          }
      }


      if(n<0){
          return 1/ans;
      }

      return ans;

      

    
    }
}