import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Task3 {
    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> input) {
        return new ArrayList<>(new LinkedHashSet<>(input));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 3, 2, 5, 1);
        System.out.println("Integers: " + removeDuplicatesPreserveOrder(numbers));

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");
        System.out.println("Strings: " + removeDuplicatesPreserveOrder(words));
    }
}

