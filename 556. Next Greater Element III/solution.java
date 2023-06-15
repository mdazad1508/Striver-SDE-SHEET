class Solution {
    public int nextGreaterElement(int n) {

        // ex - 4254321 , dip at 2 so , will swap 2 with 3(closest) not 2 with 5  then sort the remaining after swapping


        ArrayList<Integer> list = new ArrayList<>();

        while(n != 0){
            list.add(0,n%10);
            
            n= n/10;
        }

        
        int dipIndex = -1;

        for(int i=list.size()-1;i>0;i--){

            if(list.get(i)>list.get(i-1)){
                dipIndex = i-1;
                break;
            }
        }


        if(dipIndex == -1) return -1;     //no dip already maximum;
         

         // swap with closest number greater than num at dip Index in its right;
         int swapWith = -1;
         int minDiff = Integer.MAX_VALUE;
        for(int i=dipIndex+1;i<list.size();i++){

           if(list.get(i)>list.get(dipIndex)){
               int diff = list.get(i)-list.get(dipIndex);
               if(diff < minDiff){
                   minDiff = diff;
                   swapWith = i;
               }
           }
        }

        swap(list,dipIndex,swapWith);

        sort(list,dipIndex+1 ,list.size()-1);

        StringBuilder sb = new StringBuilder();

        for(int elem :list){
            sb.append(elem);
        }

        long ans =  Long.valueOf(sb.toString());

        if(ans > Integer.MAX_VALUE){
            return -1;
        }

        return (int)ans;


        
    }
    static void swap(ArrayList<Integer> list , int a , int b){
        int temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }

    static void sort(ArrayList<Integer> list , int start , int end){
         //insertion sort

         for(int i=start;i<=end;i++){

             for(int j=i;j>start;j--){
                 if(list.get(j)<list.get(j-1)){
                     swap(list,j,j-1);
                 }
             }
         }

    }
}