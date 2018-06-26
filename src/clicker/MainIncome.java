package clicker;

import javafx.beans.property.StringProperty;

public class MainIncome {
    public static long baseIncom = 0;
    public static StringProperty baseIncomeProperty;

    public static void setBaseIncomePropert() {
        baseIncomeProperty.setValue(String.valueOf(baseIncom));
    }

    public static StringProperty getBaseIncomeProperty() {
        return baseIncomeProperty;
    }
}
