package WIL.java;

public class ShortCircuit {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int a=10;
        if(a>1 || arr[100]>=10) // a>1 조건에 의해 arr[100]의 조건은 무시된다.
            System.out.println("Short Circuit");
        // 결과 : Short Circuit
    }
}
