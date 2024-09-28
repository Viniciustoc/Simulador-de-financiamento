package modelo;

public class Casa extends Financing {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;
    private static final double SEGURO_OBRIGATORIO = 80.0;

    // Construtor
    public Casa(double propertyValue, int financingPeriod, double annualInterestRate, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(propertyValue, financingPeriod, annualInterestRate);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    // Método para calcular o pagamento mensal com a opção de desconto
    public double calculateMonthlyPaymentWithDiscount(double desconto) throws DescontoMaiorDoQueJurosException {
        double monthlyPayment = (propertyValue / (financingPeriod * 12)) * (1 + (annualInterestRate / 12));
        double jurosMensal = monthlyPayment - (propertyValue / (financingPeriod * 12));

        // Verificar se o desconto é maior que o valor dos juros
        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("O desconto não pode ser maior do que o valor dos juros mensais.");
        }

        return (monthlyPayment - desconto) + SEGURO_OBRIGATORIO;
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyPayment = (propertyValue / (financingPeriod * 12)) * (1 + (annualInterestRate / 12));
        return monthlyPayment + SEGURO_OBRIGATORIO;
    }

    @Override
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * financingPeriod * 12;
    }

    @Override
    public void showFinancingData() {
        System.out.println("Valor do imóvel (Casa): R$" + propertyValue);
        System.out.println("Período do financiamento: " + financingPeriod + " anos");
        System.out.println("Taxa de juros anual: " + annualInterestRate + "%");
        System.out.println("Área construída: " + tamanhoAreaConstruida + " m²");
        System.out.println("Tamanho do terreno: " + tamanhoTerreno + " m²");
        System.out.println("Valor da parcela mensal (com seguro): R$" + calculateMonthlyPayment());
        System.out.println("Valor total do financiamento (com seguro): R$" + calculateTotalPayment());
    }
}