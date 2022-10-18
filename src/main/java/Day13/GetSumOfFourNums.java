package Day13;

/*
 ** @author LiGuanda
 ** @date  PM 9:42:28
 ** @description This is a description of GetSumOfFourNums
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

 

示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
*
* */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lenovo
 */
public class GetSumOfFourNums {


    public static void main(String[] args) {

        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> lists = fourSum(nums, -294967296);
        System.out.println("The four-num-zero arrays of the nums are" + lists);

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        // 用于存储结果
        List<List<Integer>> list = new ArrayList<>();
        // 用于对结果去重
        Set<String> set = new HashSet<>();

        //对传入数组进行排序
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {

                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];

                }

            }

        }

        // 防止数据溢出，需要将数组内数据强转为long型
        List<Long> longList = new ArrayList<>();
        for (int i : nums) {

            longList.add((long) i);

        }

        Long[] nums2 = longList.toArray(new Long[nums.length]);

        // 开始分两层进行遍历
        for (int base = 0; base < nums.length - 3; base++) {

            for (int subBase = base + 1; subBase < nums.length - 2; subBase++) {

                //复位左右的指针
                int left = subBase + 1;
                int right = nums.length - 1;

                while (left < right) {

                    if (nums2[base] + nums2[subBase] - target + nums2[left] + nums2[right] > 0) {

                        right--;

                    } else if (nums2[base] + nums2[subBase] - target + nums2[left] + nums2[right] == 0) {

                        if (!set.contains("" + nums[base] + nums[subBase] + nums[left] + nums[right])) {

                            List<Integer> subList = new ArrayList<>();
                            subList.add(nums[base]);
                            subList.add(nums[subBase]);
                            subList.add(nums[left]);
                            subList.add(nums[right]);
                            list.add(subList);
                            set.add("" + nums[base] + nums[subBase] + nums[left] + nums[right]);

                            // 为了防止因在本轮循环中找到匹配数组而过早地跳出本轮循环，刻意破坏匹配

                        }
                        right--;

                    } else if (nums2[base] + nums2[subBase] - target + nums2[left] + nums2[right] < 0) {

                        left++;

                    }

                }

            }

        }

        return list;

    }

}
