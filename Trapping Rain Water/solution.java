class Solution {
    public int trap(int[] height) {

        //water sotred = min(leftMax,rightMax)-height

        int leftMax[]  = new int[height.length];
        int rightMax[] = new int[height.length];

        int max = height[0];
        for(int i=0;i<height.length;i++){
            
            max = Math.max(max,height[i]);
            leftMax[i] = max;
        }

        max = height[height.length-1];

        for(int i=height.length-1;i>=0;i--){
            max = Math.max(max,height[i]);
            rightMax[i] = max;
        }


        int ans =0;

        for(int i=0;i<height.length;i++){

            int water = Math.min(leftMax[i],rightMax[i])-height[i];
            ans+=water;

        }

        return ans;


        
    }
}