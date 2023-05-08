package WIL.algo;

public class StringHandling {
    public static void main(String[] args) {
        // 문자열 길이 반환
        String text = "카페라떼";
        System.out.println("text.length() = " + text.length());

        // 문자열 포함 여부 확인
        String today = "오늘";
        System.out.println(today.contains("오늘")); // true
        System.out.println(today.contains("내일")); // false

        // 시작하는 문자열 동일 여부 확인
        String example = "월화수목금토일";
        example.startsWith("월화수"); // true
        example.startsWith("금토일"); // false

        // 문자열 "앞뒤" 공백 제거
        String trim = "       오늘       같은       날             ";
        System.out.println("trim.trim() = " + trim.trim());

        // 문자열 대체 (replace)

        // 문자열 자르기 (substring)

        // 문자열 소문자로 변경 ( toLowerCase() )
        // 문자열 대문자로 변경 ( toUpperCase() )
        // 문자열 내부 특정 문자 찾기 ( indexOf() ) 없으면 -1 반환
        // 특정 index 문자 반환 ( text.charAt(3) )
        // 문자열 비교
//        int value = "abc".compareTo("jzis"); // -9 (의미 abc가 더 앞이다)
//        int value = "jzis".compareTo("abc"); // 9 (의미 abc가 더 앞이다)
//        int value = "aa".compareTo("aaa"); // -1 (의미 aa가 더 앞이다)

        // 문자열 접근
        String hello = "안녕하세요 hello Java";
        for (char c : hello.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();

        // 문자열 뒤집기
        StringBuilder hello2 = new StringBuilder("안녕하세요 hello Java");
        System.out.println("hello2.reverse().toString() = " + hello2.reverse());

        // StringBuilder 메소드
        StringBuilder sb = new StringBuilder();
        sb.append("abc"); // 문자열 추가
        sb.insert(2, "kk"); // 2 위치에 kk 삽입 (→ abkkc)
        sb.delete(0, 2); // 0~1 위치의 문자열 삭제 (→ c)
        sb.deleteCharAt(2); // 2 위치의 문자 삭제 (→ ac)
        sb.setCharAt(0, 'h'); // 0 위치의 문자를 h로 변경 (→ hbc)
        sb.reverse(); // 문자열 거꾸로 뒤집기 (→ cba)
        sb.setLength(2); // 문자열 길이를 2로 줄임 (→ ab)
        sb.setLength(4); // 문자열 길이를 4로 늘림 (→ 뒤가 공백으로 채워짐)
    }
}
