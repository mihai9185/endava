import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "alice@gmail.com", "bob@yahoo.com", "carol@gmail.com",
                "david@hotmail.com", "eve@yahoo.com", "frank@gmail.com"
        );

        Map<String, List<String>> grouped = emails.stream()
                .collect(Collectors.groupingBy(email -> email.substring(email.indexOf("@"))));

        grouped.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    List<String> sortedEmails = entry.getValue().stream()
                            .sorted()
                            .toList();
                    System.out.println(entry.getKey() + " - " + sortedEmails);
                });
    }
}