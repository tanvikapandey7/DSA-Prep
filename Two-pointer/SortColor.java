public class SortColor {
    public static void main(String[] args) {
        int [] nums= {2,0,2,1,1,0} ;
        SortColor(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
public static void SortColor(int [] nums) {
      int low = 0, mid = 0, high = nums.length - 1;
      while(mid<= high) {
        if(nums[mid] == 0) {
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;
            low ++ ;
            mid ++ ;
        }
        if(nums[mid] == 1 ) {
            mid ++;
        }
        if(nums[mid] == 2) {
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high -- ;
        }
      }
  
        }
    }



