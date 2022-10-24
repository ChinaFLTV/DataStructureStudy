package Day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiGuanda
 * @date PM 7:19:35
 * @description This is a description of GenerateParenthesis
 * @since version-1.0
 */

/*
*
* 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
*
* */

public class GenerateParenthesis {


    public static void main(String[] args) {

        int n = 2;
        List<String> strings = generateParenthesis(n);
        System.out.println("The combination of " + n + " parenthesis are " + strings);

    }


    public static List<String> generateParenthesis(int n) {

        // 初始化用于存储结果的List集合
        List<String> result = new ArrayList<>();
        subGenerateParenthesis(result, 0, 0, "", n);
        return result;

    }


    public static void subGenerateParenthesis(List<String> result, int leftParenthesisNum, int rightParenthesisNum, String prevStr, int n) {

        // 如果右括号的数量多于左括号，则往后的操作一定非法，直接返回
        if (leftParenthesisNum < rightParenthesisNum) {

            return;

        }


        // 如果此时左括号全部用完，则后面的操作一定都符合操作，则直接把可能还没有用完的右括号直接进行添加,同时终止此次递归
        if (leftParenthesisNum == n) {

            prevStr += ")".repeat(Math.max(0, n - rightParenthesisNum));
            result.add(prevStr);
            return;

        }


        // 开始分别添加 (与 )
        // 添加 (
        subGenerateParenthesis(result, leftParenthesisNum + 1, rightParenthesisNum, prevStr + "(", n);

        //添加 )
        subGenerateParenthesis(result, leftParenthesisNum, rightParenthesisNum + 1, prevStr + ")", n);

    }


}
