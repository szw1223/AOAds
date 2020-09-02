public class Solution {
    public static boolean minSubArrayLen(int num) {
        int left = 0;
        int mid = 0;
        int right = num;
        int t = 0;
        while (right > left + 1) {
            mid = left + (right - left) / 2;
            t = mid * mid;
            if (t == num) {
                return true;
            }else if (t > num) {
                right = mid;
            }else {
                left = mid;
            }
        }if (right*right == num) {
            return true;
        }if (left * left == num) {
            return true;
        }return false;
    }
    public static void main(String[] args){
        minSubArrayLen(808201);
    }
}
