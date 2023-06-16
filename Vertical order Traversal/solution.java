// use priority queue if you want in sorted order at common row &col  ex (c:0,r:2,5); and (c:0,r:2,4) so list will have [4,5]
// if you use ArrayList it will have [5,4]

static ArrayList<ArrayList<Integer>> fun(Node root){

        TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map = new TreeMap<>();  //(Col,Row,NODEs)

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,root));

        while(!q.isEmpty()){

            Tuple curr = q.poll();
            int y = curr.col;
            int x = curr.row;
            Node node = curr.node;

            if(!map.containsKey(y)){
                map.put(y,new TreeMap<>());
            }

            if(!map.get(y).containsKey(x)){
                map.get(y).put(x,new ArrayList<>());
            }

            map.get(y).get(x).add(node.key);

            if(node.left != null){
                q.add(new Tuple(y-1,x+1,node.left));
            }

            if(node.right!= null){
                q.add(new Tuple(y+1,x+1,node.right));
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,ArrayList<Integer>> ps : map.values()){
            ArrayList<Integer> mylist = new ArrayList<>();
            for(ArrayList<Integer> list : ps.values()){
                while(!list.isEmpty()){
                    mylist.add(list.remove(0));
                }
            }
            ans.add(new ArrayList<>(mylist));

        }

     return ans;

    }
    static class Tuple{

        int col;
        int row;
        Node node;
        Tuple( int col , int row,Node node ){
            this.node = node;
            this.col =col;
            this.row = row;
        }
    }