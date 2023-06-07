class Solution {
    public void setZeroes(int[][] matrix) {
        

        boolean [] row = new boolean [matrix.length];
        //if any row elem is true means that row should be complete zero
        boolean [] col  = new boolean [matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(row[i]==true || col[j]==true){
                    matrix[i][j] =0;
                }
               
            }
        }

        

    }
}