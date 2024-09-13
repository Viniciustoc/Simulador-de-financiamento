package src.main;

import src.modelo.Financing;
import src.util.userInterface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Criação do objeto para interface do usuário
        userInterface userInterface = new userInterface();

        // Criação da lista de financiamentos
        ArrayList<Financing> financingsList = new ArrayList<>();

        // Solicitação de dados e criação dos financiamentos
        for (int i = 0; i < 4; i++) {
            System.out.println("Dados do financiamento #" + (i + 1) + ":");
            double propertyValue = userInterface.askPropertyValue();
            int financingPeriod = userInterface.askAnnualFinancingPeriod();
            double annualInterestRate = userInterface.askInterestRate();

            Financing financing = new Financing(propertyValue, financingPeriod, annualInterestRate);
            financingsList.add(financing);
            financing.showFinancingData();
            System.out.println(); //  linha em branco para separar os financiamentos
        }

        // Cálculo e exibição dos valores totais
        double totalPropertyValue = 0;
        double totalFinancingValue = 0;

        for (Financing financing : financingsList) {
            totalPropertyValue += financing.getPropertyValue();
            totalFinancingValue += financing.calculateTotalPayment();
        }

        System.out.println("Valor total de todos os imóveis: R$" + totalPropertyValue);
        System.out.println("Valor total de todos os financiamentos: R$" + totalFinancingValue);
    }
}

