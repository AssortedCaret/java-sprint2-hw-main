import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        //outOfFile outFile = new outOfFile();
        MonthlyReport month = new MonthlyReport();
        AnnualReport year = new AnnualReport();
        Comparsion comparsion = new Comparsion();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> ar = new ArrayList<>();
        boolean yearValue = false;
        boolean monthVlue = false;
        boolean readFileMonth = false;
        boolean readFileYear = false;
        while(true) {
            System.out.println("Введите команду: \n" +
                    "1. Считать все месячные отчёты\n" +
                    "2. Считать годовой отчёт\n" +
                    "3. Сверить отчёты\n" +
                    "4. Вывести информацию о всех месячных отчётах\n" +
                    "5. Вывести информацию о годовом отчёте\n" +
                    "0. Выход\n");
            int console = scanner.nextInt();
            if (console == 1) {
                month.readFileContentsOrNullMonth();
                monthVlue = true;
            } else if (console == 2) {
                year.readFileContentsOrNullYear();
                yearValue = true;
            } else if (console == 3) {
                if (readFileMonth == true && readFileYear == true)
                    comparsion.comparsionYearMonth();
                else System.out.println("Сначала считайте данные из файла(Команда 1 и 2)");
            } else if (console == 4) {
                if(monthVlue == true){
                    for(String str : month.monthList){
                       ar.add(str);
                    }
                    month.returnInfoMonth(ar);
                    readFileMonth = true;
                }
                else
                    System.out.println("Сначала считатйте данные из файла(Команда 1)");
            } else if (console == 5) {
                if (yearValue == true){
                    for(String str : year.yearList) {
                        ar.add(str);
                    }
                    year.returnInfoYear(ar);
                    readFileYear = true;
                }
                else System.out.println("Сначала считатйте данные из файла(Команда 2)");
            } else if (console == 0) {
                System.out.println("До свидания!");
                return;
            } else
                System.out.println("Такой команды не существует.");
        }
    }
}

