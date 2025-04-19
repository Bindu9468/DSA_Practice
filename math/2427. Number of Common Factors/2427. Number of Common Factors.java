class Solution {
    public int commonFactors(int a, int b) {
        int count=0;
        int gcd=gcd (a,b);
        for(int i=1; i*i <= gcd ;i++){
            if(gcd % i ==0){
                count++;
           if (i!=gcd/i) count++;  
        }
        }
        return count;
    }
    
    int gcd(int a, int b){
       return  (b==0) ? a : gcd(b,(a%b));
    }
}