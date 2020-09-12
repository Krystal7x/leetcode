package common;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-09-12 15:14
 */
public class MockData {


    public static List<Integer> getList(String str) {
        String[] arr = str.split(",");
        List<Integer> ans = new LinkedList<>();
        for (String s : arr) {
            ans.add(Integer.parseInt(s));
        }
        return ans;

    }


    public static List<List<Integer>> getDoubleList(String... strs) {
        List<List<Integer>> ans = new LinkedList<>();
        for (String str : strs) {
            List<Integer> list = getList(str);
            ans.add(list);
        }
        return ans;
    }
}
