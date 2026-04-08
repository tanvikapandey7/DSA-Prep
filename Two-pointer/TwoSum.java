
class TwoSum  {
    public static void main(String[] args) {
        int[] nums= {2,7,11,15};
        int target=9;
        int[] result = twoSum(nums,target);
        for(int i:result){
            System.out.println(i);
        }
    }
}
public static int[] twoSum(int[] nums, int target ) {
    int left = 0 ;
    int right = nums.length - 1;

    while(left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            return new int[] {left+1 , right+1};
        }
        else if(sum < target) {
            left ++;
        }
        else {
            right --;
        }
        return new int[]{};
    }

}