package Day10;

/*
 ** @author LiGuanda
 ** @date  PM 9:37:09
 ** @description This is a description of GetSumOfThreeNums
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

 

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
*
* */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Lenovo
 */
public class GetSumOfThreeNums {


    public static void main(String[] args) {

        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> list = threeSum(nums);
        System.out.println("The three-num-zero arrays of the nums are" + list);

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        // 创建链表，用于存储结果
        List<List<Integer>> list = new ArrayList<>();
        // 用于数据去重
        HashSet<String> set = new HashSet<>();

        // 判断传入数组长度小于3，则直接返回空链表
        if (nums.length < 3) {

            return list;

        }

        // 对数组进行排序(冒泡排序)
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {

                    nums[i] += nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];

                }

            }

        }

        // 初始化基准指针，左指针，右指针
        int base;
        int left;
        int right;

        // 开始从头到尾移动基准指针遍历数组
        for (base = 0; base < nums.length - 2; base++) {

            // 复位左右的指针
            left = base + 1;
            right = nums.length - 1;

            // 开始移动左右的指针以获取等于0的结果
            while (left < right) {

                if (nums[base] + nums[left] + nums[right] < 0) {

                    left++;

                } else if (nums[base] + nums[left] + nums[right] == 0) {

                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[base]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    if (!set.contains("" + nums[base] + nums[left] + nums[right])) {

                        list.add(subList);
                        set.add("" + nums[base] + nums[left] + nums[right]);

                    }

                    // 继续左移右指针的位置，寻找本轮循环中的下一个合适的数组
                    right--;

                } else if (nums[base] + nums[left] + nums[right] > 0) {

                    right--;

                }

            }

        }

        return list;

    }

}
