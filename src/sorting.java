import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// sort 56, 242, 922,
public class sorting {
    public int[] sort922(int[] A) {
        int i = 0;
        int j = 1;
        while (i  < A.length && j < A.length) {
            while (i < A.length) {            // 序列偶数
                if (A[i] % 2 != 0) {                // 偶数序列的值是奇数
                    break;
                }else {
                    i = i + 2;
                }
            }
            while (j < A.length){              // 序列奇数
                if (A[j] % 2 == 0) {                // 偶数序列的值是奇数
                    break;
                }else {
                    j = j + 2;
                }
            }
            // switch
            if (i < A.length && j < A.length){
                int cap = A[i];
                A[i] = A[j];
                A[j] = cap;
            }
        }
        return A;
    }

    public boolean isAnagram242(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int [] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if ( --table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public int[][] merge56(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result.toArray(new int[0][0]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            i++;
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args){
//        int[][] mat1 = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
////        int k1 = 3;
////        int [] mat1 = new int[] {3,4,5,6};
////        sorting myTest = new sorting();
////        int [] mat2 = new int [mat1.length];
////        mat2 = myTest.sort922(mat1);
////        for (int i = 0; i < mat1.length; i++) {
////            System.out.println(mat2[i]);
////        }
        int [][] interval = new int[][] {{1,2},{4,5},{2,1,},{2,4},{4,7}};
        sorting myTest = new sorting();
        int[][] mat2 = myTest.merge56(interval);
        for (int i = 0; i < mat2.length; i++){
            System.out.println(mat2[i][0]);
        }
    }
}
