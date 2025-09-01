class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int index = 0; index < arr.length; index++){   // yahan i++ nahi, index++ hona chahiye
            if(arr[index] != index + 1){   // kyunki array 1 se n elements ka hai
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
