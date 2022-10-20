package Day15;

/*
 ** @author LiGuanda
 ** @date  PM 6:16:16
 ** @description This is a description of IsValid
 ** @params
 ** @return
 ** @since version-1.0  */


/*
*
*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
*
* */


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Lenovo
 */
public class IsValid {


    public static void main(String[] args) {

        String s = "(]";
        boolean isValid = isValid(s);
        System.out.println("The validity of string that is " + s + " is " + isValid);


    }


    public static boolean isValid(String s) {

        //初始化栈,用于进行匹配抵消操作
        Stack<Character> stack = new Stack<>();
        // 用于为第一个stack元素提供配对操作
        stack.push('?');
        // 创建映射表，用于确定是否匹配
        Set<String> set = new HashSet<>();
        set.add("()");
        set.add("[]");
        set.add("{}");

        // 开始循环遍历
        for (Character ch : s.toCharArray()) {

            // 只需判断右符号的情况
            if (')' == ch || ']' == ch || '}' == ch) {

                Character prevCh = stack.peek();
                // 如果配对成功，则直接将当前未修改状态下的stack的top元素pop出
                if (set.contains("" + prevCh + ch)) {

                    stack.pop();

                } else {

                    return false;

                }


            } else {

                // 若是左符号，则无条件地入栈
                stack.push(ch);

            }

        }

        // 若所有能抵消的符号对全部抵消后，栈为空，则证明符合要求，返回TRUE
        return stack.size() == 1;

    }


}
