package com.example;

import com.example.app.MessagePrinter;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // Spring Container ачаалах — Bean-үүдийг скан хийж үүсгэнэ
        ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        // Container-аас Bean авах
        MessagePrinter printer = context.getBean(MessagePrinter.class);

        // Ажиллуулах
        printer.print();

        // Container хаах
        ((AnnotationConfigApplicationContext) context).close();
    }
}
