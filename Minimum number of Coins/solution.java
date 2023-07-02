class Solution{
    static List<Integer> minPartition(int N)
    {
        
        List<Integer> list = new ArrayList<>();
        
        
        while(N !=0){
            
            if(N>=2000){
                list.add(2000);
                N -= 2000;
            }else if(N>=500){
                list.add(500);
                N -= 500;
                
            }else if(N>=200){
                
                list.add(200);
                N-=200;
                
            }else if(N>=100){
                
                list.add(100);
                N-= 100;
                
            }else if(N>=50){
                
                list.add(50);
                N-=50;
                
            }else if(N>=20){
                
                list.add(20);
                N-=20;
                
            }else if(N>=10){
                
                list.add(10);
                N-=10;
                
            }else if(N>=5){
                
                list.add(5);
                N-=5;
                
            }else if(N>=2){
                
                list.add(2);
                N-=2;
                
            }else if(N>=1){
                
                list.add(1);
                N-=1;
                
            }
        }
        
        return list;
        
    }
}