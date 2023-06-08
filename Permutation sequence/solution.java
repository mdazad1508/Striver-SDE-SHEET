class Solution {
    public String getPermutation(int n, int k) {

        //n = 4 and k = 17 
        //total permutations  = n! (indexed from 0 to n!-1)
        //so kth permution =  k-1th permution in 0 indexed
        k--;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
           list.add(i+1);
        }

        StringBuilder sb = new StringBuilder();

       

       while(list.size() !=0){

           int index = k / factorial(n-1);
           sb.append(list.get(index));
           list.remove(index);

           k = k % factorial(n-1);
           n--;


       }

       return sb.toString(); 


    }
    static int factorial(int n){
       if(n<=1){
           return 1;
       }
       int product = 1;

       for(int i=1;i<=n;i++){
           product *= i;
       }
       return product;
    }
}