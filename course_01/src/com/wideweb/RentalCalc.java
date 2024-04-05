package com.wideweb;

public class RentalCalc {

    private final int MONTHS_YEAR = 12;

    public float calculateRentalYield(float monthlyIncome, float propertyValue) {
        float totalYearlyIncome = monthlyIncome * MONTHS_YEAR;
        return divide(totalYearlyIncome, propertyValue) * 100;
    }

    private float divide(float n1, float n2) {
        return n1 / n2;
    }
}
