class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;

        while(low<=high){
            long mid = low + (high-low)/2;
            long sqr = mid*mid;

            if(sqr == num){
                return true;
            } else if( sqr < num){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }
}