package WIL.algo;

/*
 * 다음과 같은 배열이 있을 때,
 * arr [5,7,-1,14,3,12,1,4], k = 3
 * 크기가 k인 부분 배열 중 합이 가장 큰 부분배열을 반환하라.
 * Key : 배열의 범위에서 제외되는 원소는 subtract, 범위에 포함되는 원소는 add
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {5, 7, -1, 14, 3, 12, 1, 4};
        int k = 3;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE; // 모든 원소들이 음수일 경우를 대비

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i]; // 범위에 포함되는 원소는 add
            if (i >= k) {
                windowSum -= arr[i - k]; // 범위에서 제외되는 원소는 subtract
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        System.out.println("maxSum = " + maxSum);
    }
}
