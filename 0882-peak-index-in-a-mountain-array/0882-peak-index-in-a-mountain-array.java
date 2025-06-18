class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end  = arr.length-1;
        while(start<end){
            int mid  = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in  decresing part of array 
                // this may be the answwr but you may look for left
                // this is why end!=mid-1
                end = mid;
            }
            else{
                // you are in acending part of an array
                start = mid+1;// because we know that mid+1 elemnt  is greater tahn mid
            }
        }
        //  int the end start ==end and pointing to the largest number because of the two check above
        // start and end are alwyas trring to find max eklemnt in the above two checks 
        // hence when they are pointing to one elemnt that is the max on ebecause that is what tring to find 
        // more elaboartion at every point for start and end they have the best possible ans
        // and if we are saying that only one item is remainig hence because of above line 
        return start; // or return end as both are equal
    }
}