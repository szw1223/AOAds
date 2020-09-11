import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        }
    }

    public List<int[]> merge56(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result;
        }
        for (int i = 0; i < intervals.length; i++) {
            Arrays.sort(intervals[i]);
        }
        return result;
    }

    public static void main(String[] args){
//        int[][] mat1 = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
//        int k1 = 3;
        int [] mat1 = new int[] {3,4,5,6};
        sorting myTest = new sorting();
        int [] mat2 = new int [mat1.length];
        mat2 = myTest.sort922(mat1);
        for (int i = 0; i < mat1.length; i++) {
            System.out.println(mat2[i]);
        }
    }
}
