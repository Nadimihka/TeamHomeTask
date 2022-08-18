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

        String[] saleProducts = {
                "Йогурт",
                "Печенье",
                "Макароны"
        };

        int[] salePrices = {
                30,
                50,
                100
        };

        int[] saleNumb = new int[salePrices.length];
        int saleOllSum = 0;
        int saleNumProduct;
        int saleAmount;
        double sumPoz;

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prises[i] + " руб/шт");
        }

        System.out.println(System.lineSeparator() + "Список товаров по акции 2=3: ");
        for (int j = 0; j < saleProducts.length; j++) {
            System.out.println((j + 6) + ". " + saleProducts[j] + " " + salePrices[j] + " руб/шт");
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
                if ((numProduct + 1) > products.length + saleProducts.length || (numProduct + 1) <= 0) {
                    System.out.println("Введенное число не должно быть меньше 1 и больше 8");
                    continue;
                }
                amount = Integer.parseInt(parts[1]);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Нужно вводить только числа, а не текст!");
                continue;
            }

            if (numProduct < 0 || numProduct >= (products.length + saleProducts.length)) {
                System.out.println("Некорректный ввод позиции! Нужно выбрать номер позиции из списка!");
                continue;
            }

            if (numProduct < products.length) {
                if (amount == 0) {
                    numb[numProduct] = 0;
                }
                if ((amount < 0) && (numb[numProduct] + amount < 0)) {
                    System.out.println("Некорректный ввод, " +
                            "количество товара " + products[numProduct] +
                            " отрицательно и будет обнулено");
                    numb[numProduct] = 0;
                } else {
                    numb[numProduct] += amount;
                }
            } else {
                saleNumProduct = numProduct - products.length;
                if (amount == 0) {
                    saleNumb[saleNumProduct] = 0;
                }
                if ((amount < 0) && (saleNumb[saleNumProduct] + amount) < 0) {
                    System.out.println("Некорректный ввод, " +
                            "количество товара " + saleProducts[saleNumProduct] +
                            " отрицательно и будет обнулено");
                    saleNumb[saleNumProduct] = 0;
                } else {
                    saleNumb[saleNumProduct] += amount;
                }
            }
        }

            System.out.println("Ваша корзина: ");

            for (int i = 0; i < numb.length; i++) {
                if (numb[i] != 0) {
                    int sum = numb[i] * prises[i];
                    System.out.println(products[i] + " " + numb[i] + " шт " +
                            prises[i] + " руб/шт " + sum + " в сумме");
                    ollSum += sum;
                }
            }

            System.out.println("Итого: " + ollSum);

            System.out.println("Ваша корзина c товарами по акции: ");

            for (int i = 0; i < saleNumb.length; i++) {
                if (saleNumb[i] != 0) {
                    sumPoz = (3 * (int) (saleNumb[i] / 3) * salePrices[i]) / 1.5 +
                            (saleNumb[i] - 3 * (int) (saleNumb[i] / 3)) * salePrices[i];

                    System.out.println(saleProducts[i] + " " + saleNumb[i] + " шт " +
                            salePrices[i] + " руб/шт " + sumPoz + " в сумме");

                    saleOllSum += sumPoz;
                }
            }

            System.out.println("Итого по акции: " + saleOllSum);
            System.out.println(System.lineSeparator() + "Итого за все: " + (ollSum + saleOllSum));
        }
    }
