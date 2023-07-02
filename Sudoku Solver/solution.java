class Solution {
    public void solveSudoku(char[][] board) {

    fun(board);

    }

    static boolean fun(char[][] board){

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){

                if(board[i][j]=='.'){

                    for(int v=1;v<=9;v++){
                         char x = Integer.toString(v).charAt(0);
                        if(isValidValue(x,i,j,board)){
                           board[i][j] = x;
                           if(fun(board)) return true;
                           board[i][j] = '.';
                        }

                    }

                    return false;

                }
            }
        }

        return true;
    }

    static boolean isValidValue(char x, int row,int col, char[][] board){

        //check if row contains x;

        for(int i=0;i<9;i++){
            if(board[row][i]==x){
                return false;
            }
        }

        //check if col contains x;

        for(int i=0;i<9;i++){
            if(board[i][col]==x){
                return false;
            }
        }

        //check if sub-box contains x;

        for(int i=0;i<9;i++){
            if(board[3*(row/3) +i/3][3*(col/3)+i%3]==x){
                return false;
            }
           
        }

        return true;


    }

}