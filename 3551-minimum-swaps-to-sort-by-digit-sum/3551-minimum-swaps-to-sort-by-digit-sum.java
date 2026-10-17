class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (x, y) -> {
            int a = digSum(x[0]);
            int b = digSum(y[0]);

            if(a != b){
                return a - b;
            }
            
            return x[0] - y[0];
        });

        int[] pos = new int[n];

        for(int i = 0; i < n; i++){
            pos[arr[i][1]] = i;
        }

        boolean[] fix = new boolean[n];
        int swaps = 0;

        for(int i = 0; i < n; i++){
            if(fix[i]){
                continue;
            }

            int j = i;
            int count = 0;

            while(!fix[j]){
                fix[j] = true;
                j = pos[j];
                count++;
            }

            if(count > 1){
                swaps += count - 1;
            }
        }

        return swaps;
    }

    private int digSum(int num){
        int sum = 0;

        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}