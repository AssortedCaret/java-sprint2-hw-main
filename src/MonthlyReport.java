import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MonthlyReport {
    ArrayList<String> monthList;
    MonthlyReport(){
        monthList = new ArrayList<>();
    }

    static String pathMonth = "";
    static String contentMonth = "";
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> valueMonth = new ArrayList<>();

     ArrayList readFileContentsOrNullMonth()  //чтение файла, необходимо передать путь к файлу
    {
        System.out.println("Введите количество доступных месяцев на данный момент:");
        byte amountMonth = scanner.nextByte();
        for (int i = 1; i < amountMonth + 1; i++) {
            pathMonth = "C:\\Users\\chufi\\dev\\java-sprint2-hw-main\\resources\\m.20210" + i + ".csv";
            try {
                contentMonth = Files.readString(Path.of(pathMonth));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
                contentMonth = null;
            }
            String[] lines = contentMonth.split("\n");  //делит на отдельные стоки ка на отдельные элементы
            for (String str : lines) {
                String[] lineContents = str.split(",");
                for (String st : lineContents) {
                    monthList.add(st);
                }
            }
        }//System.out.print(monthList); // проверка полученных значений
        return monthList;
    }


    void returnInfoMonth(ArrayList<String> lineContents){  //название мес., прибыльный товар(кол-во на цену), большая трата

        int profiItem = 0; // прибыльный товар
        int spendItem = 0; // убыточный товар
        String profiItemName = "";
        String spendItemName = "";
        int amountProfit = 0; // количество товара
        int priceProfit = 0;
        int amount = 0;
        int price = 0;
        int month = 0;
        int totalIncomeMonth = 0; //общий доход за месяц
        int totalConsumMonth = 0; // общий расход за месяц
        lineContents.add("newMonth");
        for(int i = 5; i < lineContents.size(); i++){
            if(lineContents.get(i).equals("FALSE")){
                amountProfit = Integer.parseInt(lineContents.get(i + 1));
                priceProfit = Integer.parseInt(lineContents.get(i + 2));
                if((amountProfit * priceProfit) > profiItem){
                    profiItem = amountProfit * priceProfit;
                    profiItemName = lineContents.get(i - 1);
                }
                totalIncomeMonth += amountProfit * priceProfit;
            }
            else if(lineContents.get(i).equals("TRUE")){
                amount = Integer.parseInt(lineContents.get(i + 1));
                price = Integer.parseInt(lineContents.get(i + 2));
                if((amount * price) > spendItem){
                    spendItem = amount * price;
                    spendItemName = lineContents.get(i - 1);
                }
                totalConsumMonth += amount * price;
            }
            else if(lineContents.get(i).equals("newMonth") || lineContents.get(i).equals("item_name")){
                month += 1;
                System.out.println("Номер месяца " + month);
                System.out.println("Самый прибыльный товар: " + profiItemName + "\n" + "Прибыль: " + profiItem);
                System.out.println("Самый дорогой товар: " + spendItemName + "\n" + "Трата: " + spendItem);
                valueMonth.add(totalIncomeMonth);
                valueMonth.add(totalConsumMonth);
//                infoMonth.put(month, valueMonth);
                totalIncomeMonth = 0;
                totalConsumMonth = 0;
                profiItem = 0;
                spendItem = 0;

            }
        }
//        System.out.println(infoMonth);
    }


}
















