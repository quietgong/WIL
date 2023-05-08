package WIL.java.CollectionFramework;

import java.util.*;

public class ListEx {
    public static void main(String[] args) {
        BasicListMethods();
        convertListType();
    }

    private static void BasicListMethods() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list.clear(); // 전체 값 삭제
        list.isEmpty(); // 길이가 0이면 true, 아니면 false
        list.size(); // list 길이

        list.add("서울"); // list 가장 뒤에 서울 삽입
        list.add(0, "대전"); // 0 위치에 대전 삽입 (0:대전, 1:서울)
        list2.add("부산");
        list.addAll(list2); // list 가장 뒤에 list2 전부 삽입 list : [대전, 서울, 부산]
        list.get(0); // 0 위치의 값 반환 (대전)
        list.set(2, "대전"); // 2 위치의 값을 대구로 변경 [대전, 서울, 대전]
        list.indexOf("대전"); // 대구의 첫번째 인덱스 반환 (0)
        list.lastIndexOf("대전"); // 대구의 마지막 인덱스 반환 (2)
        list.remove(1); // 1 위치의 값 삭제
        list.remove("대전"); // 첫번째 대전 삭제
        list.removeAll(list2); // list에서 list2에 들어있는 모든 값을 삭제
        list.retainAll(list2); // list에서 list2에 들어있는 값을 제외한 모든 값을 삭제
        list.contains("서울"); // 서울이 list에 있으면 true, 없으면 false
        list.containsAll(list2); // list에 list2의 모든 값이 포함되어 있으면 true
    }

    public static void convertListType() {
        // 문자열 배열 -> List
        String[] temp = new String[]{"java", "python", "c++"};
        List<String> list = new ArrayList<>(Arrays.asList(temp));
        System.out.println("list = " + list); // list = [java, python, c++]

        // List -> 문자열 배열
        String[] temps = list.toArray(new String[0]);
        System.out.println("temps = " + Arrays.toString(temps)); // temps = [java, python, c++]

        // 정수 배열 필터링
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) integerList.add(i); // 1~10까지의 정수를 integerList 에 삽입
        integerList.removeIf(k -> k % 2 != 0); // 람다식으로 list 홀수 원소 모두 제거
        System.out.println("integerList = " + integerList); // intArr = [2, 4, 6, 8, 10]

        // 정수 배열 -> List
        int[] intArray = {1, 2, 3, 4, 5};
        integerList.clear();
        for (int i = 0; i < intArray.length; i++) integerList.add(intArray[i]);
        System.out.println("integerList = " + integerList); // integerList = [1, 2, 3, 4, 5]

        // List -> 정수 배열
        int[] intArr = integerList.stream().mapToInt(i -> i).toArray();
        System.out.println("intArr = " + Arrays.toString(intArr)); // intArr = [1, 2, 3, 4, 5]

        orderList(integerList);
    }

    public static void orderList(List<Integer> list) {
        Collections.sort(list);
        System.out.println("list = " + list); // list = [1, 2, 3, 4, 5]
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("list = " + list); // list = [5, 4, 3, 2, 1]
    }
}
