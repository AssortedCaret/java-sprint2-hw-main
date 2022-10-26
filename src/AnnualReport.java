import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AnnualReport {
    ArrayList<String> yearList;
    AnnualReport(){
     yearList = new ArrayList<>();
    }
    static String pathYear = "";
    static String contentYear = "";
    static Scanner scanner = new Scanner(System.in);
    byte amountYear = 0;
    static ArrayList<Integer> incomeList = new ArrayList<>();
    static ArrayList<Integer> expenseList = new ArrayList<>();
    ArrayList readFileContentsOrNullYear()  //чтение файла, необходимо передать путь к файлу
    {
        System.out.println("Введите последнюю цифру нужного года:");
        amountYear = scanner.nextByte();
        pathYear = "C:\\Users\\chufi\\dev\\java-sprint2-hw-main\\resources\\y.202" + amountYear + ".csv";
            try {
                contentYear = Files.readString(Path.of(pathYear));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
                contentYear = null;
            }
            String[] lines = contentYear.split("\n");
            for (String str : lines) {
                String[] lineContents = str.split(",");
                for(String st : lineContents){
                    yearList.add(st);
                }
            }
        return yearList;
    }

// заполняем мапу месяцем и значением прибыли:
    void returnInfoYear(ArrayList<String> lineContents){            // нужно название месяца, прибыль, ср. доход, ср. расход
        Integer midSumIncome = 0; // сумма доходов
        Integer midSumExpense = 0;// сумма расходов
        HashMap<String, Integer> fullYear = new HashMap<>();
            for(int j = 0; j < lineContents.size(); j++) { //перебераем данные из списка, чтобы получить прибыль
                String value = lineContents.get(j);
                if (value.equals("01") && lineContents.get(j+2).equals("false")) {
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    incomeList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
                else if (value.equals("01") && lineContents.get(j+2).equals("true")){
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    expenseList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
                if (value.equals("02") && lineContents.get(j+2).equals("false")) {
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    incomeList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
                else if (value.equals("02") && lineContents.get(j+2).equals("true")){
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    expenseList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
                if (value.equals("03") && lineContents.get(j+2).equals("false")) {
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    incomeList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
                else if (value.equals("03") && lineContents.get(j+2).equals("true")){
                    Integer amount = Integer.valueOf(lineContents.get(j + 1));
                    expenseList.add(amount);
                    if(!fullYear.containsKey(value))
                        fullYear.put(value, amount);
                    else {
                        fullYear.get(value);
                        amount += fullYear.get(value);
                        fullYear.put(value, amount);
                    }
                }
            }
//        System.out.println(fullYear);// для проверки [month, amount, is_expense, 1593150, false, 350000, true, 810000, false, 14000, true, 90000, true, 2430000, false]
        System.out.println("Информация за 202" + amountYear + " год");
        System.out.println("Номер месяца и Прибыль:\n" + fullYear);
        for(Integer i : incomeList) {
            midSumIncome += i;
            midSumIncome = midSumIncome / 3;
        }
        System.out.println("Средний доход за год: " + midSumIncome);

        for(Integer j : expenseList) {
            midSumExpense += j;
            midSumExpense = midSumExpense / 3;
        }
        System.out.println("Средний расход за год: " + midSumExpense);
        }












    }


