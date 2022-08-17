import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {
                "Молоко",
                "Яблоки",
                "Сыр",
                "Картофель",
                "Хлеб",
        };

        int[] prises = {
                80,
                50,
                200,
                35,
                45
        };

        int[] numb = new int[products.length];

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prises[i] + " руб/шт");
        }

        int ollSum = 0;
        int numProduct = 0;
        int amount = 0;

        while (true) {
            System.out.println(System.lineSeparator() + "Выберите товар и количество или нажмите end");
            String input = scanner.nextLine();//1 2
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("Некорректный ввод! Нужно ввести два числа!");
                continue;
            }

            try {
                numProduct = Integer.parseInt(parts[0]) - 1;
                if ((numProduct + 1) > products.length || (numProduct + 1) <= 0) {
                    System.out.println("Введенное число не должно быть меньше 1 и больше 5");
                    continue;
                }
                amount = Integer.parseInt(parts[1]);
                if (amount <= 0) {
                    System.out.println("Количество выбранного продукта не может быть меньше 1");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Нужно вводить только числа, а не текст!");
                continue;
            }

            if (numProduct < 0 || numProduct >= products.length) {
                System.out.println("Некорректный ввод позиции! Нужно выбрать номер позиции из списка!");
                continue;
            }

            numb[numProduct] += amount;//сумма штук введенного

            int sum = amount * prises[numProduct];
            ollSum += sum;// подсчет общей суммы списка
        }

        System.out.println("Ваша корзина: ");

        for (int i = 0; i < numb.length; i++) {
            if (numb[i] != 0) {
                System.out.println(products[i] + " " + numb[i] + " шт " +
                        prises[i] + " руб/шт " + (numb[i] * prises[i]) + " в сумме");
            }
        }

        System.out.println("Итого: " + ollSum);
    }
}
