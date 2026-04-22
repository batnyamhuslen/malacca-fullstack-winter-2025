package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;
    private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Бүхэл тоо авах (Min/Max хязгаартай)
     */
    public int getInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.err.printf("Error: Please enter a number between %d and %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input. Please enter a valid integer.");
            }
        }
    }

    /**
     * Бүхэл тоо авах (Хязгааргүй)
     */
    public int getInt(String prompt) {
        return getInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Бутархай тоо авах
     */
    public double getDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.err.printf("Error: Please enter a value between %.2f and %.2f.%n", min, max);
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    /**
     * Хоосон биш текст авах
     */
    public String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.err.println("Error: This field cannot be empty.");
        }
    }

    /**
     * Форматлагдсан огноо авах
     */
    public LocalDate getDate(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print(prompt + " (YYYY-MM-DD): ");
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Error: Invalid date format. Please use YYYY-MM-DD (e.g., 2024-05-20).");
            }
        }
    }

    /**
     * Тийм/Үгүй асуулт
     */
    public boolean getConfirmation(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.err.println("Error: Please enter 'y' for Yes or 'n' for No.");
        }
    }

    /**
     * Цэс харуулах ба сонголт авах
     */
    public int getMenuChoice(String title, String[] options) {
        System.out.println("\n=== " + title + " ===");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s%n", i + 1, options[i]);
        }
        System.out.println("0. Back/Exit");
        return getInt("Choose an option: ", 0, options.length);
    }

    // Email validation
    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public String getEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();
            if (isValidEmail(email)) {
                return email;
            }
            System.err.println("Error: Invalid email format (e.g., name@domain.com).");
        }
    }
}
