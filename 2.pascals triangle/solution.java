class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans  = new ArrayList<>();
         
        if(numRows ==0){
            return ans;
        }

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);

        int i=0;

        while(i != numRows-1){

            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=0;j<ans.get(i).size()-1;j++){

               list.add(ans.get(i).get(j) + ans.get(i).get(j+1));
            }
            list.add(1);
            ans.add(list);

            i++;

        }

        return ans;
 
    }
}