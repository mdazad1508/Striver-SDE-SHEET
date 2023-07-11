Largest Rectangle in Histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int [] leftSmaller = new int[heights.length];
        //next smaller left elment index
        
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){

            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }

          
          if(st.isEmpty()){
              leftSmaller[i] =-1;
          }else{
              leftSmaller[i] = st.peek();
          }
          st.add(i);

        }

        int [] rightSmaller = new int[heights.length];

         
        Stack<Integer> st1 = new Stack<>();
        for(int i =n-1;i>=0;i--){

            while(!st1.isEmpty() && heights[st1.peek()]>= heights[i]){
                st1.pop();
            }

          
          if(st1.isEmpty()){
              rightSmaller[i] =n;
          }else{
              rightSmaller[i] = st1.peek();
          }
          st1.add(i);

        }


       int max =0;

        for(int i=0;i<n;i++){
            
            int area = (rightSmaller[i]-leftSmaller[i]-1)*heights[i];
            max = Math.max(max,area);
        }

        return max;
        
    }
