public class EnglishGreeting implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello!");
    }

    @Override
    public String getLanguage() {
        return "English";
    }
}