package luo.li.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @Author liluo
 * @create 2023/10/9 15:23
 */
public class Demo56 {
    public static void main(String[] args) {
        Demo56 demo56 = new Demo56();
        int[][] intervals1 = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(Arrays.deepToString(demo56.merge(intervals1)));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(demo56.merge(intervals2)));
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < L) {
                merged.add(new int[]{L,R});
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
