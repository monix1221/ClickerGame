package clicker.income;

public class FruitIncome {
    public long income = 0L;

    public long onTimeIncrease = 0L;

    public synchronized long getCurrentFruitIncome() {
        return income;
    }

    public synchronized void addOnTimeIncreaseFruitIncome(long valueToIncrease) {
        onTimeIncrease += valueToIncrease;
    }

    public synchronized void increaseCurrentFruitIncome() {
        long newValue = onTimeIncrease + income;
        setCurrentFruitIncome(newValue);
    }

    public synchronized void setCurrentFruitIncome(long value) {
        income = value;
    }
}
