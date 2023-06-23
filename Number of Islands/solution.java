class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int i, int j){
            this.row= i;
            this.col= j;
        }
    }
    public int numIslands(char[][] grid) {

//here 4 directions not 8;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        int count=0;

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    bfs(new Pair(i,j),grid,visited);
                }
            }
        }

        return count;
        
    }
    static void bfs(Pair p ,char [][] grid, boolean[][] visited ){
         
         Queue<Pair> q = new LinkedList<>();
         q.add(p);
         visited[p.row][p.col] = true;

         while(!q.isEmpty()){

             Pair curr = q.poll();
             int i= curr.row;
             int j= curr.col;
            
            //marking the neighbors visited 

             //left neighbour;

             if(j-1 >=0 && !visited[i][j-1]  && grid[i][j-1]=='1'){
                  visited[i][j-1] = true;
                  q.add(new Pair(i,j-1));
             }

             //right neighbour;

             if(j+1<grid[0].length  && !visited[i][j+1] && grid[i][j+1]=='1'){
                 visited[i][j+1] = true;
                  q.add(new Pair(i,j+1));
             }

             //top neigbhor
              if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]=='1'){
                 visited[i-1][j] = true;
                  q.add(new Pair(i-1,j));
             }


             //botoom neighbour
              if(i+1<grid.length && !visited[i+1][j] && grid[i+1][j]=='1'){
                 visited[i+1][j] = true;
                  q.add(new Pair(i+1,j));
             }

         }

    }
}