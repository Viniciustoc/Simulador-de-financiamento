package modelo;

public class Terreno extends Financing {
    private String tipoZona;
    private static final double ACRECIMO_PARCELA = 0.02;

    // Construtor
    public Terreno(double propertyValue, int financingPeriod, double annualInterestRate, String tipoZona) {
        super(propertyValue, financingPeriod, annualInterestRate);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyPayment = (propertyValue / (financingPeriod * 12)) * (1 + (annualInterestRate / 12));
        return monthlyPayment * (1 + ACRECIMO_PARCELA);
    }

    @Override
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * financingPeriod * 12;
    }

    @Override
    public void showFinancingData() {
        System.out.println("Valor do imóvel (Terreno): R$" + propertyValue);
        System.out.println("Período do financiamento: " + financingPeriod + " anos");
        System.out.println("Taxa de juros anual: " + annualInterestRate + "%");
        System.out.println("Tipo de zona: " + tipoZona);
        System.out.println("Valor da parcela mensal (com acréscimo): R$" + calculateMonthlyPayment());
        System.out.println("Valor total do financiamento (com acréscimo): R$" + calculateTotalPayment());
    }
}
