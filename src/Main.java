import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        
        int result = 0;
        String operator = strings[1];
        try {
            int first = Integer.parseInt(strings[0]);
            int second = Integer.parseInt(strings[2]);
            if (first > 10 || first < 1 || second > 10 || second < 1 || !operator.matches("[-+*/]")) {
                throw new Exception("Ошибка!");
            }
            
            result = switch (operator) {
                case "+" -> first + second;
                case "-" -> first - second;
                case "*" -> first * second;
                case "/" -> first / second;
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
            return String.valueOf(result);
        } catch (NumberFormatException e) {
           e.printStackTrace();
        }
        return String.valueOf(result);
    }
}
