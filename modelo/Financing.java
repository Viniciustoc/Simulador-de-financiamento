package src.modelo;

public class Financing {
    //attributes

    private static double propertyValue;
    private int financingPeriod;
    private double annualInterestRate;

    //Getter

    public double getPropertyValue(){
        return this.propertyValue;
    }

    public int getFinancingPeriod(int i){
        return this.financingPeriod;
    }

    public double getAnnualInterestRate(int i){
        return this.annualInterestRate;
    }

    //methods

    //construtor
    public Financing (double desiredPropertyValue, int annualFinancingPeriod, double annualInterestRate){
        this.propertyValue = desiredPropertyValue;
        this.financingPeriod = annualFinancingPeriod;
        this.annualInterestRate = annualInterestRate;
    }


    public double calculateMonthlyPayment(){
        return (this.propertyValue / (this.financingPeriod * 12)) * (1 + (this.annualInterestRate / 12));
    }

    public double calculateTotalPayment(){
        return calculateMonthlyPayment() * this.financingPeriod * 12;
    }


    // method for showing financing data

    public void showFinancingData() {
        System.out.println("Valor do imóvel: R$" + propertyValue);
        System.out.println("Período do financiamento: " + financingPeriod + " anos");
        System.out.println("Taxa de juros anual: " + annualInterestRate + "%");
        System.out.println("Valor da parcela mensal: R$" + calculateMonthlyPayment());
        System.out.println("Valor total do financiamento: R$" + calculateTotalPayment());
    }

}



