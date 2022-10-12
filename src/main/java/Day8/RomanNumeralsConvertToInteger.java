package Day8;

/*
 ** @author LiGuanda
 ** @date  PM 7:06:14
 ** @description This is a description of RomanNumeralsConvertToInteger
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。
*
* */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 */
public class RomanNumeralsConvertToInteger {


    public static void main(String[] args) {

        String romanNumerals = "MCMXCIV";
        int num = romanToInt(romanNumerals);
        System.out.println("The num of the " + romanNumerals + " is " + num);

    }


    public static int romanToInt(String s) {

        // 如果字符串值为空，则直接返回0
        if ("".equals(s)) {

            return 0;

        }

        // 首先定义以下所有的罗马数字-->阿拉伯数字的所有原子型常量映射
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // 将传入的罗马数字字符串转换为字符数组
        char[] numStr = s.toCharArray();
        // 用于存储转换后的数值
        int num = 0;
        // 记录上一轮字符状态的映射值
        int prev = 1;


        // 开始从字符串的右端向左进行字符遍历
        for (int i = numStr.length - 1; i >= 0; i--) {

            // 当本轮字符状态映射值大于等于上一轮的字符映射值时，则进行数值相加操作,反之则进行数值相减操作
            if (map.get(numStr[i]) >= prev) {

                num += map.get(numStr[i]);

            } else {

                num -= map.get(numStr[i]);

            }

            // 更新前一个的字符数值映射状态
            prev = map.get(numStr[i]);

        }

        return num;

    }


}
