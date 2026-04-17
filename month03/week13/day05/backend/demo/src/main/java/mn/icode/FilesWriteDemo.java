import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class FilesWriteDemo {
    public static void exer3() {
        try {
            Files.writeString(Path.of("output.txt"), "Hello, World!");

            Files.writeString(
                Path.of("output.txt"),
                "\nAppended line",
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
