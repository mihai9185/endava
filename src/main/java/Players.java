public class Players {
    String name;
    int score;
    int age;

    public Players(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " Score: " + score + ", Age: " + age;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }
}