class Solution {
    public boolean validMountainArray(int[] arr) {

        int n = arr.length;
        if(n <3){
            return false;
        }
        int index = 0;
        while(index < n-1){
            if(arr[index] < arr[index+1]){
                index++;
            } else {
                break;
            }
        }

        if(index == 0 || index==n-1){
            return false;
        }

        while(index <n-1){
            if(arr[index] > arr[index+1]){
                index++;
            } else {
                break;
            }
        }

        return (index == n-1);
    }
}