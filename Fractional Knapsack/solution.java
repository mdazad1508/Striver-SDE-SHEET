/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class itemComparator implements Comparator<Item>{
    
    @Override
    public int compare(Item a, Item b){
        double x1 = (double)a.value/(double)a.weight;
        double x2 = (double)b.value/(double)b.weight;
        //for sorting in descending order;
        if(x1 < x2){
            return 1;
        }else if(x1>x2){
            return -1;
        }else{
            return 0;
        }
    }
}


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,new itemComparator());
        
        int remWt = W;
        double profit =0;
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i].weight<=remWt){
                profit += arr[i].value;
                remWt -= arr[i].weight;
            }else{
               profit += ((double)remWt/(double)arr[i].weight ) * arr[i].value;
               break;
            }
            
        }
        
        return profit;
    }
}