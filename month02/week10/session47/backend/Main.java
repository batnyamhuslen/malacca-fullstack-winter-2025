public class Main {
    public static void main(String[] args) {
        Greetable[] greetings = {
            new MongolianGreeting(),
            new EnglishGreeting(),
            new JapaneseGreeting()
        };

        for (Greetable g : greetings) {
            System.out.println("Language: " + g.getLanguage());
            g.greet();
            System.out.println();
        }
    }
}