package modelo;

public class Apartamento extends Financing {
    private int numeroVagasGaragem;
    private int numeroAndar;

    // Construtor
    public Apartamento(double propertyValue, int financingPeriod, double annualInterestRate, int numeroVagasGaragem, int numeroAndar) {
        super(propertyValue, financingPeriod, annualInterestRate);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calculateMonthlyPayment() {
        double taxaMensal = annualInterestRate / 12;
        int meses = financingPeriod * 12;
        return (propertyValue * Math.pow(1 + taxaMensal, meses) * taxaMensal) / (Math.pow(1 + taxaMensal, meses) - 1);
    }

    @Override
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * financingPeriod * 12;
    }

    @Override
    public void showFinancingData() {
        System.out.println("Valor do imóvel (Apartamento): R$" + propertyValue);
        System.out.println("Período do financiamento: " + financingPeriod + " anos");
        System.out.println("Taxa de juros anual: " + annualInterestRate + "%");
        System.out.println("Número de vagas na garagem: " + numeroVagasGaragem);
        System.out.println("Número do andar: " + numeroAndar);
        System.out.println("Valor da parcela mensal: R$" + calculateMonthlyPayment());
        System.out.println("Valor total do financiamento: R$" + calculateTotalPayment());
    }
}
