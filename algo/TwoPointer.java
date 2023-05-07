package WIL.algo;

public class TwoPointer {
    public static void main(String[] args) {
        /*
         * 다음과 같은 배열이 있을 때,
         * arr = [1,3,6,5,2,7,9],  x = 9
         * 부분 배열의 합이 x인 부분 배열을 개수를 구하라.
         */
        int[] arr = {1, 3, 6, 5, 2, 7, 9};
        int x = 9;
        int result = findSubArray(arr, x);
        System.out.println("result = " + result);
        int resultByTwoPointer = findSubArrayTwoPointer(arr, x);
        System.out.println("resultByTwoPointer = " + resultByTwoPointer);

        /*
         * 다음과 같은 "정렬된" 배열이 있을 때,
         * arr = [2,4,5,7,11,15],  x = 15
         * 두 원소의 합이 x인 원소의 각각 인덱스를 반환하라.
         */
        int[] arr2 = {2, 4, 5, 7, 11, 15};
        int target = 15;
        System.out.println("findTwoIndexes(arr2, target) = " + findTwoIndexes(arr2, target));
    }

    public static String findTwoIndexes(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        StringBuilder sb = new StringBuilder();
        while(left!=right){
            if(arr[left]+arr[right]>x)
                right--;
            else if(arr[left]+arr[right]<x)
                left++;
            
            if(arr[left]+arr[right]==x){
                sb.append(left).append(",");
                sb.append(right);
                break;
            }
        }
        return sb.toString();
    }

    public static int findSubArrayTwoPointer(int[] arr, int x) {
        // 투포인터 : O(n)
        int count = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (left < arr.length) {
            if (sum > x || right == arr.length) {
                sum -= arr[left];
                left++;
            } else { // 합이 x보다 작거나 같을 때
                sum += arr[right];
                right++;
            }
            if (sum == x) {
                count++;
            }
        }
        return count;
    }

    public static int findSubArray(int[] arr, int x) {
        // 완전탐색 : O(n^2)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == x) {
                    count++;
                    break;
                } else if (sum > x) {
                    break;
                }
            }
        }
        return count;
    }
}
