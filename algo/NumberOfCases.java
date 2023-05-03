package WIL.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

/* Output
* [1, 2, 3]
Permutation (뽑은 뒤 줄 세운다.)
1
2
3
1 2
1 3
2 1
2 3
3 1
3 2
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
*
Combination (뽑기만한다.)
1
2
3
1 2
1 3
2 3
1 2 3
 */
public class NumberOfCases {
    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            for (int num : out) System.out.print(num + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

        System.out.println("Permutation");
        for (int r = 1; r <= arr.length; r++)
            permutation(arr, new int[r], new boolean[arr.length], 0, r);

        System.out.println("Combination");
        for (int r = 1; r <= arr.length; r++)
            combination(arr, new boolean[arr.length], 0, 0, r);
    }
}
