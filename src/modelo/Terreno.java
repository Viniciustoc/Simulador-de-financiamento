package modelo;

public class Terreno extends Financing {

    private static final double ACRÉSCIMO = 0.02; // 2% de acréscimo

    public Terreno(double desiredPropertyValue, int annualFinancingPeriod, double annualInterestRate) {
        super(desiredPropertyValue, annualFinancingPeriod, annualInterestRate);
    }

    @Override
    public double calculateMonthlyPayment() {
        // Calcula o valor da parcela mensal normal
        double baseMonthlyPayment = super.calculateMonthlyPayment();
        // Aplica o acréscimo de 2%
        return baseMonthlyPayment * (1 + ACRÉSCIMO);
    }

    @Override
    public void showFinancingData() {
        super.showFinancingData();
        System.out.println("Acréscimo de 2% aplicado nas parcelas devido ao risco de inadimplência.");
        System.out.println("Valor total da parcela mensal (com acréscimo): R$" + calculateMonthlyPayment());
    }
}
