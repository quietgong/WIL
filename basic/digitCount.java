package WIL.basic;

public class digitCount {
    public static int[] solution(String s) {
        int[] digits = new int[10];
        // 문자열에서 0~9가 나타나는 개수
        for (int i = 0; i < 10; i++)
            digits[i] = s.length() - s.replace(String.valueOf(i), "").length();
        return digits;
    }

    public static void main(String[] args) {
        int[] result = solution("1233345");
        for (int i = 0; i < result.length; i++) {
            System.out.println(i+" 출현 개수 : " + result[i]);
            /*
            0 출현 개수 : 0
            1 출현 개수 : 1
            2 출현 개수 : 1
            3 출현 개수 : 3
            ...
            */
        }
    }
}
