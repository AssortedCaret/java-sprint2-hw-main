
public class Comparsion {
    void comparsionYearMonth(){

                    if(MonthlyReport.valueMonth.get(0) == AnnualReport.incomeList.get(0))
                        System.out.println("Расхождение доходов за первый месяц нет");
                    else if(MonthlyReport.valueMonth.get(0) != AnnualReport.incomeList.get(0))
                        System.out.println("Имеется расхождение в доходах за первый месяц");
                    if(MonthlyReport.valueMonth.get(1) == AnnualReport.expenseList.get(0))
                        System.out.println("Расхождение расходов за первый месяц нет");
                    else if(MonthlyReport.valueMonth.get(1) != AnnualReport.expenseList.get(0))
                        System.out.println("Имеется расхождение в расходах за первый месяц");

                    if(MonthlyReport.valueMonth.get(2) == AnnualReport.incomeList.get(1))
                        System.out.println("Расхождение доходов за второй месяц нет");
                    else if(MonthlyReport.valueMonth.get(2) != AnnualReport.incomeList.get(1))
                        System.out.println("Имеется расхождение в доходах за второй месяц");
                    if(MonthlyReport.valueMonth.get(3) == AnnualReport.expenseList.get(1))
                        System.out.println("Расхождение расходов за второй месяц нет");
                    else if (MonthlyReport.valueMonth.get(3) != AnnualReport.expenseList.get(1))
                        System.out.println("Имеется расхождение в расходах за второй месяц");

                    if(MonthlyReport.valueMonth.get(4) == AnnualReport.incomeList.get(2))
                        System.out.println("Расхождение доходов за третий месяц нет");
                    else if(MonthlyReport.valueMonth.get(4) != AnnualReport.incomeList.get(2))
                        System.out.println("Имеется расхождение в доходах за третий месяц");
                    if(MonthlyReport.valueMonth.get(5) == AnnualReport.expenseList.get(2))
                        System.out.println("Расхождение расходов за третий месяц нет");
                    else if (MonthlyReport.valueMonth.get(5) != AnnualReport.expenseList.get(2))
                        System.out.println("Имеется расхождение в расходах за третий месяц");
        }
    }

