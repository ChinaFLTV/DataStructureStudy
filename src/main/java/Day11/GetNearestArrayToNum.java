package Day11;

/*
 ** @author LiGuanda
 ** @date  PM 9:27:39
 ** @description This is a description of GetNearestArrayToNum
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

 

示例 1：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
示例 2：

输入：nums = [0,0,0], target = 1
输出：0

*
* */

import java.util.Arrays;

/**
 * @author Lenovo
 */
public class GetNearestArrayToNum {


    public static void main(String[] args) {

        int[] nums = {-100, -98, -2, -1};
        int i = threeSumClosest(nums, -101);
        System.out.println("The nearest sum of the array which  is " + Arrays.toString(nums) + " is " + i);

    }


    public static int threeSumClosest(int[] nums, int target) {


        // 对传入的数组进行排序（冒泡排序）
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {

                    nums[i] += nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];

                }

            }

        }


        // 用于存储最近的距离值
        int nearestDistance = nums[0] + nums[1] + nums[nums.length - 1];

        // 开始移动基准指针循环遍历
        for (int base = 0; base < nums.length - 2; base++) {

            // 复位左右的指针
            int left = base + 1;
            int right = nums.length - 1;

            // 开始在本轮循环中移动两端指针获取最近距离值
            while (left < right) {

                if (Math.abs(nums[base] + nums[left] + nums[right] - target) < Math.abs(nearestDistance - target)) {

                    nearestDistance = nums[base] + nums[left] + nums[right];

                }

                // 确定和的值是在target哪一边靠近的，以便后续指针的移动
                if (nums[base] + nums[left] + nums[right] > target) {

                    right--;

                } else if (nums[base] + nums[left] + nums[right] == target) {

                    return target;

                } else if (nums[base] + nums[left] + nums[right] < target) {

                    left++;

                }

            }

        }

        return nearestDistance;

    }


}
