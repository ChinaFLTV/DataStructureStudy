package Day19;

import java.util.Arrays;

/**
 * @author LiGuanda
 * @date PM 5:59:37
 * @description This is a description of RemoveDuplicates
 * @since version-1.0
 */

/*
*
* 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。

将最终结果插入 nums 的前 k 个位置后返回 k 。

不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

判题标准:

系统会用下面的代码来测试你的题解:

int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
如果所有断言都通过，那么您的题解将被 通过。

 

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
*
* */

public class RemoveDuplicates {


    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int distinctNumsLength = removeDuplicates(nums);
        System.out.println("The length of array which gotten rid of duplicates is " + distinctNumsLength);

    }


    public static int removeDuplicates(int[] nums) {

        // 若数组所包含的元素数量小于2，则直接返回原数组的长度
        if (nums.length <= 1) {

            return nums.length;

        }

        // 初始化两个指针
        int left = 0;
        int right = 1;

        // 开始同时向右进行遍历
        while (right < nums.length) {

            // 若二者数值相等并且两指针间距大于0（否则在交换数据时出现异常），则右指针右移一位
            if ((nums[left] != nums[right])) {

                // 若二者不相等，则交换二者数值，并将两个指针均向右移动一位
                if (right - left > 1) {

                    nums[left + 1] += nums[right];
                    nums[right] = nums[left + 1] - nums[right];
                    nums[left + 1] = nums[left + 1] - nums[right];

                }

                left++;

            }

            right++;

        }

        return left + 1;

    }


}
