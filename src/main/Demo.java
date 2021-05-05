import com.alisasbbtn.datastructures.SinglyLinkedList;

public class Demo {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.push("Hello");
        list.push("World");
        list.insert(1, "my");
        list.reverse();
    }
}
