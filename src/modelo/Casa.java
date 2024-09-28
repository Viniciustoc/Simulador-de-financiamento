package modelo;

public class Casa extends Financing {

    private static final double SEGURO_OBRIGATORIO = 80.0;

    public Casa(double desiredPropertyValue, int annualFinancingPeriod, double annualInterestRate) {
        super(desiredPropertyValue, annualFinancingPeriod, annualInterestRate);
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyPayment = super.calculateMonthlyPayment();
        return monthlyPayment + SEGURO_OBRIGATORIO; // Adiciona o seguro obrigatório
    }

    @Override
    public void showFinancingData() {
        super.showFinancingData();
        System.out.println("Valor do seguro obrigatório: R$" + SEGURO_OBRIGATORIO);
        System.out.println("Valor total da parcela mensal (com seguro): R$" + calculateMonthlyPayment());
        System.out.println("Valor total do financiamento (com seguro): R$" + calculateTotalPayment());
    }
}