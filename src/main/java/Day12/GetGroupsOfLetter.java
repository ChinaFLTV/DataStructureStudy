package Day12;

/*
 ** @author LiGuanda
 ** @date  PM 7:29:35
 ** @description This is a description of GetGroupsOfLetter
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 */
@SuppressWarnings("unused")
public class GetGroupsOfLetter {


    public static void main(String[] args) {

        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println("The combinations of the digits " + digits + " is " + list);

    }


    public static List<String> letterCombinations(String digits) {

        // 初始化链表，用于存储组合结果
        List<List<String>> list = new ArrayList<>();

        // 初始化数字与字母的映射表
        Map<String, List<String>> map = new HashMap<>(8);
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        // 如果长度等于1，则直接返回该键位所包含的字母;如果长度等于0，则直接返回空链表
        if (digits.length() <= 1) {

            return map.getOrDefault(digits, new ArrayList<>());

        }

        // 开始按层次进行遍历
        for (int level = 0; level < digits.length(); level++) {

            combination(level, digits, list, map);

        }

        return list.get(digits.length() - 1);

    }


    // 开始将本层与上一次的元素进行自由组合
    public static void combination(int level, String digits, List<List<String>> list, Map<String, List<String>> map) {

        List<String> subList = new ArrayList<>();

        // 获取上一层遍历得到的结果
        if (level > 0) {

            List<String> prevList = list.get(level - 1);
            for (String str : prevList) {

                int k = 0;
                while (k < map.get(digits.substring(level, level + 1)).size()) {

                    List<String> letterList = map.get(digits.substring(level, level + 1));
                    subList.add(str + letterList.get(k));
                    k++;

                }

            }

        } else {

            // 区别第一层组合操作
            int k = 0;
            while (k < map.get(digits.substring(level, level + 1)).size()) {

                List<String> letterList = map.get(digits.substring(level, level + 1));
                subList.add(letterList.get(k));
                k++;

            }

        }

        list.add(subList);

    }


}
