class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        fun(0,n,ans,new int[n][n]);
        return ans;

    
    }
    
    static void fun(int index,int n , List<List<String>> ans, int[][] dummy){

        if(index==n){
            List<String> list = findAnswer(dummy);
            ans.add(new ArrayList<>(list));
            return;
        }
       
         for(int i=0;i<n;i++){

             if(isValid(index,i,dummy)){
                 dummy[index][i] =1;
                 fun(index+1,n,ans,dummy);
                 dummy[index][i] =0;
             }
         }

    }
    static boolean isValid(int row, int col, int [][] dummy){

        //check row

        for(int i=0;i<dummy.length;i++){
            if(dummy[row][i]==1){
                return false;
            }
        }

        //check col

        for(int i=0;i<dummy.length;i++){
            if(dummy[i][col]==1){
                return false;
            }
        }

        //check topleft

        int x =  row;
        int y = col;

        while(x>=0 && y>=0){
            if(dummy[x][y]==1){
                return false;
            }
            x--;
            y--;
        }


        //check topright;

        x =  row;
        y  = col;

        while(x>=0 && y<dummy.length){
            if(dummy[x][y]==1){
                return false;
            }
            x--;
            y++;
        }

        //check bottom left;

        x =  row;
        y  = col;

        while(x<dummy.length && y>=0){
            if(dummy[x][y]==1){
                return false;
            }
            x++;
            y--;
        }

        //check bottom right;

        x =  row;
        y  = col;

        while(x<dummy.length && y<dummy.length){
            if(dummy[x][y]==1){
                return false;
            }
            x++;
            y++;
        }


        return true;


    }

    static List<String> findAnswer(int [][] dummy){
        
        List<String> list = new ArrayList<>();
        for(int [] row : dummy){

            String s = "";
            for(int i=0;i<row.length;i++){
                if(row[i]==0){
                    s += '.';
                }else{
                    s += 'Q';
                }
            }
            list.add(s);
        }

        return list;
    }
    
}