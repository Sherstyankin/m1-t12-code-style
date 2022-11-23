import java.util.Scanner;


public class CalculateDeposit {
    double calculateComplexPercent(double sumOfMoney, double yearRate, int depositPeriod) {
        double income = sumOfMoney * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(income, 2);
    }

    double calculateSimplePercent(double sumOfMoney,
                                  double yearRate, int depositPeriod) {
        return round(sumOfMoney + sumOfMoney * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateRevenue() {
        int years;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int sumOfMoney = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        years = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double revenue = 0;

        if (depositType == 1) {
            revenue = calculateSimplePercent(sumOfMoney, 0.06, years);
        } else if (depositType == 2) {
            revenue = calculateComplexPercent(sumOfMoney, 0.06, years);
        }
        System.out.println("Результат вклада: "
                + sumOfMoney + " за " + years + " лет превратятся в " + revenue);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculateRevenue();
    }
}
