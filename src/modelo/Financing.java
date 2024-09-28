package modelo;

public abstract class Financing {
    // Atributos comuns a todos os tipos de financiamento
    protected double propertyValue;
    protected int financingPeriod;
    protected double annualInterestRate;

    // Construtor
    public Financing(double propertyValue, int financingPeriod, double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingPeriod = financingPeriod;
        this.annualInterestRate = annualInterestRate;
    }

    // Métodos abstratos a serem implementados pelas subclasses
    public abstract double calculateMonthlyPayment();

    public abstract double calculateTotalPayment();

    public abstract void showFinancingData();

    // Getters
    public double getPropertyValue() {
        return propertyValue;
    }

    public int getFinancingPeriod() {
        return financingPeriod;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}