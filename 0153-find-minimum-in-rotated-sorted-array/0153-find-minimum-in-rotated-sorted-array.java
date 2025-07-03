class Solution {
    public int findMin(int[] nums) {
        int start= 0;
        int end = nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[end]) {// iska matlab target hamara right side me hoga
            start= mid+1;
        }
        // agr yaisa nhi h to target hamara left me hoga 
        else{
            end =mid;// ho sakta h mid hi minimum ho ya usse left me
        }
        
    }
    // loop break when start==end ho jaye
    return nums[start];
}
}