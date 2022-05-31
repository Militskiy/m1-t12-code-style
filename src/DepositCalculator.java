import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double percentAmount = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(percentAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int decimalPlaces) {
        double ScaLe = Math.pow(10, decimalPlaces);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);
        int depositAmount;
        int depositPeriod;
        double totalAmount = 0;

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        int command = scanner.nextInt();
        if (command == 1) {
            totalAmount = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (command == 2) {
            totalAmount = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + totalAmount);
    }
}
