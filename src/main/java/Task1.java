import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Players> players = Arrays.asList(
                new Players("Alex", 9, 21),
                new Players("Andreea", 5, 22),
                new Players("Ion", 7, 21),
                new Players("Daniel", 10, 18),
                new Players("Diana", 8, 20),
                new Players("Maria", 6, 23)
        );

        List<Players> sortedPlayers = players.stream()
                .sorted(Comparator.comparing(Players::getScore).reversed()
                        .thenComparing(Players::getAge))
                .toList();

        System.out.println("Top 3 Players:");
        sortedPlayers.stream().limit(3).forEach(System.out::println);
    }
}
