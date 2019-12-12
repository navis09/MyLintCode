package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParenthesis
 * TODO 自动生成的注释，需修改
 *
 * @author jinxin
 */
public class GenerateParenthesis {

    private List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        generateHelper(sb, n, n);

        return list;
    }

    private void generateHelper(StringBuilder sb, int left, int right) {
        StringBuilder builder = new StringBuilder(sb);
        if (left == 0 && right == 0) {
            list.add(builder.toString());
        } else if (left == 0) {
            builder.append(')');
            generateHelper(builder, left, right - 1);
        } else if (left == right) {
            builder.append('(');
            generateHelper(builder, left - 1, right);
        } else {
            generateHelper(new StringBuilder(sb).append('('), left - 1, right);
            generateHelper(new StringBuilder(sb).append(')'), left, right - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

}
