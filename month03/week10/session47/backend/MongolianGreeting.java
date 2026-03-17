public class MongolianGreeting implements Greetable {
    @Override
    public void greet() {
        System.out.println("Сайн байна уу!");
    }

    @Override
    public String getLanguage() {
        return "Монгол";
    }
}
