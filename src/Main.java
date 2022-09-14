import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String[] operations = {"добавить", "показать", "удалить", "найть"};

    public static void main(String[] args) {
        for (int i = 0; i < operations.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + operations[i]);
        }
        System.out.println();
        List<String> products = new ArrayList<>();
        int countProduct = 0;
        Scanner scan = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("ВЫБИРИТЕ НОМЕР ОПЕРАЦИИ: ");
            input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.print("  Какую покупку надо добавить: ");
                    input = scan.nextLine();
                    products.add(input.toLowerCase());
                    countProduct++;
                    System.out.println("\tитого в списке продуктов: " + countProduct);
                    break;
                case 2:
                    System.out.println("  Список продуктов: ");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + products.get(i));
                    }
                    break;
                case 3:
                    System.out.println("\tСписок покупок: ");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + products.get(i));
                    }
                    System.out.print("  Какой продукт хотите удалить? Введите номер или название: ");
                    input = scan.nextLine();
                    try {
                        int product = Integer.parseInt(input);
                        String remoteProduct = products.get(product - 1);
                        products.remove(product - 1);
                        System.out.println("  Покупка " + remoteProduct + " удалена. Список продуктов: ");
                    } catch (NumberFormatException e) {
                        System.out.println("  Покупка " + input + " удалена. Список продуктов: ");
                        products.remove(input);
                    } finally {
                        countProduct--;
                        for (int i = 0; i < products.size(); i++) {
                            System.out.println("\t" + (i + 1) + ". " + products.get(i));
                        }
                        System.out.println("\tитого в списке продуктов: " + countProduct);
                    }
                    break;
                case 4:
                    System.out.print("  Введите текст для поиска: ");
                    input = scan.nextLine();
                    for (int i = 0; i < products.size(); i++) {
                        search(i, products.get(i), input);
                    }
                    break;
            }
        }
        System.out.println("\tПРОГРАММА ЗАВЕРШЕНА");
    }

    public static void search(int num, String text, String word) {
        String[] words = text.split(" ");
        for (String str : words) {
            if (str.equals(word.toLowerCase())) {
                System.out.println("\t" + (num + 1) + ". " + text);
            }
        }
    }
}
