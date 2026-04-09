

public class Dup {
    public static void main(String[] agrs) {
        int [] nums = {1,2,3,4,3};
        int result = Dup(nums);
        System.out.println(result);
    }
}
public static int Dup(int[] nums) {
   int  slow = nums[0];
   int  fast = nums[0];

    do { 
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);
    slow = nums[0];
    while(slow!= fast){
        slow = nums[slow];
        fast = nums[fast];;

    }
    return slow;
}
