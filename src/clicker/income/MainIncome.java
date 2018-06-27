package clicker.income;

public class MainIncome {
    private static long baseIncome = 0;

    public static synchronized long getBaseIncome() {
        return baseIncome;
    }

    public static synchronized void setBaseIncome(long income) {
        baseIncome = income;
    }

    public static synchronized void decreaseMainIncome(long value) {
        baseIncome -= value;
    }

}
