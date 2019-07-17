
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiayk
 * @date 2019/7/17
 */
public class FrequencySort {

    /**
     * 示例 1:
     *
     * 输入:
     * "tree"
     *
     * 输出:
     * "eert"
     *
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * @param args
     */
    public static void main(String[] args){
        frequencySort("tree");
    }

    //本题重点在于排序，将字符和出现次数放到map，中，对map排序，进行字符串拼接即可
    public static String frequencySort(String s){
        Map<Character,Integer> countMap = new HashMap<>();
        char[] ch = s.toCharArray();
        //用map 统计每个字符出现的次数
        for (int i = 0; i < ch.length; i++) {
            if (countMap.containsKey(ch[i])){
                countMap.put(ch[i], countMap.get(ch[i])+1);
            }else {
                countMap.put(ch[i], 1);
            }
        }

        //通过Arraylist构造函数吧map.entrySet()转化为list(map没有按值排序的方法，我们要把map转化为list,用比较器进行排序，map是无序的，在空间上的无序)
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(countMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 逆序排序（从大到小），要顺序排序，o1-o2
                return o2.getValue() - o1.getValue();
            }
        });

        //用字符串类StrinBuilder（非线程安全，不支持并发），用来拼接（操作）字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将排好序的列表遍历，得到排好序的集合，然后按值遍历，将键加入sb中，最后输出（集合的遍历，最优方法，entry
        for (Map.Entry<Character,Integer> map : list) {
            for (int i = 0; i < map.getValue(); i++) {
                stringBuilder.append(map.getKey());
            }
        }
        return stringBuilder.toString();
    }
}

