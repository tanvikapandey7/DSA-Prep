import java.util.Arrays;


class Closest {
    public int[] threeSum(int[] nums, int target) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        int result = nums[0]+ nums[1] + nums[2];
        for(int i =0 ; i< n-2;i++) {
            int j = i+1 , k = n ;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum ;  
                }
                if(sum < target) {
                    j++ ;
                } else {
                    k-- ;
                }
            }
        }
        return result ; 
    }
}
 
    public static int  main(String[] args) {
         int[] nums = {-1,2,1,-4} ;
        int target = 1 ;
        System.out.println (result);
        
    }