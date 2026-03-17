public class JapaneseGreeting implements Greetable {
    @Override
    public void greet() {
        System.out.println("こんにちは!");
    }

    @Override
    public String getLanguage() {
        return "日本語";
    }
}