package modelo;

public class Apartamento extends Financing {

    public Apartamento(double desiredPropertyValue, int annualFinancingPeriod, double annualInterestRate) {
        super(desiredPropertyValue, annualFinancingPeriod, annualInterestRate);
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = (getAnnualInterestRate() / 100) / 12; // Taxa mensal
        int totalMonths = getFinancingPeriod() * 12; // Período em meses

        // Fórmula do sistema PRICE para calcular o pagamento mensal
        return (getPropertyValue() * Math.pow(1 + monthlyInterestRate, totalMonths) * monthlyInterestRate) /
                (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);
    }

    @Override
    public void showFinancingData() {
        super.showFinancingData();
        System.out.println("Sistema de amortização: PRICE");
    }
}
