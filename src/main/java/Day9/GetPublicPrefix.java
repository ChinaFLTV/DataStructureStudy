package Day9;

/*
 ** @author LiGuanda
 ** @date  PM 6:34:34
 ** @description This is a description of GetPublicPrefix
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

 

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 

提示：

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
*
* */

import java.util.Arrays;

/**
 * @author Lenovo
 */
public class GetPublicPrefix {


    public static void main(String[] args) {

        String[] strs = {"dog", "racecar", "car"};
        String prefix = longestCommonPrefix(strs);
        System.out.println("The public prefix of " + Arrays.toString(strs) + " is " + prefix);

    }


    public static String longestCommonPrefix(String[] strs) {

        // 假定第一个字符串为公共前缀
        String prefix = strs[0];
        // 进行两两横向比较
        for (int i = 1; i < strs.length; i++) {

            // 如果当前字符串是以当前状态的prefix为前缀，则直接进入下一轮比较
            while (!strs[i].startsWith(prefix)) {

                // 如果当前状态下的prefix不满足当前字符串，则将当前的prefix尾部删减一个字符
                prefix = prefix.substring(0, prefix.length() - 1);
                // 当prefix删减为空字符串时，则直接返回
                if ("".equals(prefix)) {

                    return "";

                }

            }

        }

        return prefix;

    }


}
