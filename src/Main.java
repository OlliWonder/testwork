import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String calc(String input) throws Exception {
        if (input.length() < 5 || input.length() > 7) {
            throw new Exception("Ошибка!");
        }
        
        String[] strings = input.split(" ");
        if (strings.length != 3) {
            throw new Exception("Ошибка!");
        }
        
        String operator = strings[1];
        try {
            int first = Integer.parseInt(strings[0]);
            int second = Integer.parseInt(strings[2]);
            if (first > 10 || first < 1 || second > 10 || second < 1 || !operator.matches("[-+*/]")) {
                throw new Exception("Ошибка!");
            }
            switch (operator) {
                case "+" -> {
                    return String.valueOf(first + second);
                }
                case "-" -> {
                    return String.valueOf(first - second);
                }
                case "*" -> {
                    return String.valueOf(first * second);
                }
                case "/" -> {
                    return String.valueOf(first / second);
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("Ошибка!");
        }
        return null;
    }
}
