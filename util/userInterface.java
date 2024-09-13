package src.util;

import java.util.Scanner;

public class userInterface {
    Scanner sc = new Scanner(System.in);


    public double askPropertyValue() {
        double propertyValue;
        do {
            System.out.print("Qual é o valor do imóvel? ");
            propertyValue = sc.nextDouble();
            if (propertyValue <= 0) {
                System.out.println("O valor do imóvel deve ser positivo.");
            }
        } while (propertyValue <= 0);
        return propertyValue;
    }

    public int askAnnualFinancingPeriod() {
        int financingPeriod;
        do {
            System.out.print("Qual o prazo do financiamento em anos? ");
            financingPeriod = sc.nextInt();
            if (financingPeriod <= 0 | financingPeriod>50) {
                System.out.println("O prazo do financiamento deve ser positivo e nao pode exceder 50 anos.");
            }
        } while (financingPeriod <= 0 | financingPeriod >50);
        return financingPeriod;
    }

    public double askInterestRate() {
        double interestRate;
        do {
            System.out.print("Qual é a taxa de juros estipulada? ");
            interestRate = sc.nextDouble();
            if (interestRate <= 0 | interestRate >30) {
                System.out.println("A taxa de juros deve ser positiva e nao pode exceder 30%.");
            }
        } while (interestRate <= 0 | interestRate >30);
        return interestRate;
    }
}