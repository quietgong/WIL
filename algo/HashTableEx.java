package WIL.algo;

import java.util.LinkedList;
class HashTable {
    class Node {
        String key;
        String value;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        // value - setter
        void value(String value) {
            this.value = value;
        }

        // value - getter
        String value() {
            return this.value;
        }
    }

    LinkedList<Node>[] data; // 배열방
    HashTable(int size) {
        this.data = new LinkedList[size];
    }
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null)
            return null;
        for (Node node : list) {
            if (node.key.equals(key))
                return node;
        }
        return null;
    }
    int hashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray())
            // 문자열의 각 요소들의 아스키코드를 더한 값을 해쉬코드로
            hashCode += c;
        return hashCode;
    }
    int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }
    String get(String key) {
        int hashCode = hashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        if (node == null)
            return "Not Found";
        else {
            return node.value();
        }
    }
    void put(String key, String value) {
        int hashCode = hashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value(value); // 기존 키값에 대한 value가 있으면 해당 value에 덮어쓰기
        }
    }
}
public class HashTableEx {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("김연아", "피겨스케이팅");
        h.put("손흥민", "축구");
        System.out.println(h.get("김연아"));
        System.out.println(h.get("손흥민"));
        // 피켜스케이팅
        // 축구
    }
}
