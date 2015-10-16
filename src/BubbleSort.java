import java.util.List;

/**
 * Created by watershed2106 on 10/13/15.
 */
public class BubbleSort {
    public static int[] bubble (int[] nums) {
        int count = 0;
        for(int i=0;i < nums.length - 1;i++){
            for(int j=0;j < nums.length - 1 - i;j++){
                if(nums[j] > nums[j+1]) {
                    count++;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        System.out.println(count);
        for(int i = 0;i < nums.length;i++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {985, 0, 682, 163, 959, 714, 809, 45, 131, 729, 343, 717,
                94, 686, 811, 60, 83, 813, 945, 290, 196, 673, 413, 610, 753};
        int[] nums2 = {
                698, 510, 673, 109, 166, 157, 323, 672, 964, 303, 60, 18, 332, 18, 555
        };
        int[] nums3 = {
                874, 180, 338, 767, 391, 560, 769, 397, 46, 147, 468, 428, 46, 873, 716, 491, 811, 876, 279, 545,
                602, 961, 123, 259, 250, 431, 531, 637, 114
        };

        bubble(nums3);
    }
}
