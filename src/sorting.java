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

    public int[] selectionSort(int [] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i ++) {
            int maxIndex = 0;
            for (int j = i; j < arr.length; j ++) {
                if (arr[i] < arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(arr, i, maxIndex);
        }
        return arr;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int [] mergeSort(int [] arr, int left, int right) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
//            merge(arr, left, right);
            return arr;
        }
        return new int[0];
    }

//    public int [] merge(int [] arr, int left, int right) {
//        if (right == left) {
//            return
//        }
//    }


    public void mergeSortSavingMemory(int[] arr, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                arr[left++] = helper[leftIndex++];
            } else {
                arr[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            arr[left++] = helper[leftIndex++];
        }
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
