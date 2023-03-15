import Toys.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Для подсчета шанса выигрыша решил учитывать как "шанс" игрушки, так и их количество в "коробке",
         * что дает более объективный розыгрыш.
         * Самым простым было создание отдельного списка с итоговым количеством игрушек (умножение шанса на количество).
         * В итоге мы не привязаны к итоговым шансам в 100% и можем произвольно задавать "вес" для выигрыша.
         * (в идеале от 0 до 100 в % показателе)
         */
        ArrayList<Toy> listToy = new ArrayList<Toy>();
        LinkedList<Toy> listWinningToys = new LinkedList<Toy>();

        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.printf("Выберите действие:\n" +
                        "1 - Добавить игрушку в розыгрыш\n" +
                        "2 - Произвести розыгрыш (можно повторно)\n" +
                        "3 - Добавить игрушку в список призов\n" +
                        "4 - Вывести список призовых игрушек\n" +
                        "5 - Выход\n");
                int inputCommand = input.nextInt();
                input.nextLine();
                if (inputCommand == 5) {
                    input.close();
                    System.exit(1);
                } else if (inputCommand == 1) {
                    System.out.println("Выберите игрушку для добавления: 1 - Bear, 2 - Doll, 3 - Ball, 4 - Pony");
                    int inputId = input.nextInt();
                    input.nextLine();
                    System.out.println("Введите количество игрушки: ");
                    int inputQuantity = input.nextInt();
                    input.nextLine();
                    System.out.println("Введите шанс выигрыша (от 1 до 100): ");
                    int inputWinningChance = input.nextInt();
                    input.nextLine();
                    if (inputWinningChance > 100 || inputWinningChance < 1) {
                        System.out.println("Введен некорректный шанс выигрыша игрушки\n");
                        continue;
                    }
                    switch (inputId) {
                        case 1:
                            listToy.add(new Bear(inputQuantity, inputWinningChance));
                            break;
                        case 2:
                            listToy.add(new Doll(inputQuantity, inputWinningChance));
                            break;
                        case 3:
                            listToy.add(new Ball(inputQuantity, inputWinningChance));
                            break;
                        case 4:
                            listToy.add(new Pony(inputQuantity, inputWinningChance));
                            break;
                        default:
                            System.out.println("Введите верный индекс игрушки\n");
                            break;
                    }
                } else if (inputCommand == 2) {
                    ArrayList<Toy> listToysTotal = new ArrayList<Toy>();
                    for (Toy itemToy: listToy) {
                        for (int i = 0; i < (itemToy.getWinningСhance() * itemToy.getQuantity()); i++) {
                            listToysTotal.add(itemToy);
                        }
                    }

                    listWinningToys = getWinningListToys(listToysTotal);

                } else if (inputCommand == 3) {
                    Writer write = new Writer(listWinningToys);
                } else if (inputCommand == 4) {
                    System.out.println(listWinningToys);
                } else {
                    System.out.println("Некорректный ввод\n");
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /**
     * Создание списка-очередь с выигрышными игрушками
     */
    public static LinkedList<Toy> getWinningListToys (ArrayList<Toy> boxWithToy) {
        LinkedList<Toy> resultWinninListToys = new LinkedList<Toy>();

        while ( boxWithToy.size() > 0) {
            Collections.shuffle( boxWithToy); // перемешиваем список

            resultWinninListToys.addLast(boxWithToy.get(0)); // добавляем в конец списка выйгрыша

            deleteToys(boxWithToy, boxWithToy.get(0).getWinningСhance(), boxWithToy.get(0).getId());
        }

        return resultWinninListToys;
    }


    /**
     * Удаление призовой игрушки из общего списка с игрушками
     */
    public static void deleteToys(ArrayList<Toy> inputToyList, int total, int id) {
        int i = 0;
        Iterator<Toy> toys = inputToyList.iterator();
        while (i < total) {
            Toy nextToy = toys.next();
            if (nextToy.getId() == id) {
                toys.remove();
                i++;
            }
        }
    }
}