import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S {
    public static int kWeakestRows(int[] nums) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();

        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        int flag = 0;
        int target = 4;
        int FF = 0;
        int [] newnum = new int [nums.length];

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }
        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }else if (nums[1] == target){
                return 1;
            }else {
                return -1;
            }
        }

        if (nums.length == 3) {
            if (nums[0] == target) {
                return 0;
            }else if (nums[1] == target){
                return 1;
            }else if (nums[2] == target){
                return 2;
            } else {
                return -1;
            }
        }

        while (right >= left) {
            if (nums[0] < nums[nums.length - 1] ){
                break;
            }
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
                FF++;
            }if (nums[mid] < nums[left]) {
                right = mid;
                FF++;
            }
            if (nums[mid] > nums[mid + 1]) {
                flag = mid + 1;
                break;
            }
            if (nums[mid] < nums[mid - 1]) {
                flag = mid;
                break;
            }
        }
        for (int i = 0; i < nums.length - flag; i++) {
            newnum[i] = nums[flag + i];
        }
        for (int i = 0; i < flag; i++) {
            newnum[nums.length - flag + i] = nums[i];
        }
        int Left = 0;
        int Right = nums.length - 1;
        int Mid = 0;
        int Flag = -1;
        while (Right >= Left) {
            Mid = Left + (Right - Left) / 2;
            if (newnum[Mid] == target) {
                Flag = Mid;
                break;
            }else if(newnum[Mid] < target) {
                Left = Mid + 1;
            }else{
                Right = Mid - 1;
            }
        }
        if (Flag == -1) {
            return -1;
        }

        if (FF == 0) {
            return Flag;
        }else {
            if (newnum[Flag] == nums[flag]){
                return flag;
            }
            if (Flag < nums.length - flag){
                return Flag + flag ;
            }else {
                return Flag + flag - nums.length;
            }
        }
    }
    public static void main(String[] args){
//        int[][] mat1 = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
//        int k1 = 3;
        int [] mat1 = new int[] {3,4,5,6,7,1,2};
        int hh = kWeakestRows(mat1);
        System.out.println(hh);
//        for (int i = 0; i < hh.length; i++) {
//            System.out.println(hh);
//        }
    }
}

