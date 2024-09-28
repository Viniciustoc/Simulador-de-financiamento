package Main;

import modelo.Financing;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.userInterface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Criação do objeto para interface do usuário
        userInterface userInterface = new userInterface();

        // Criação da lista de financiamentos
        ArrayList<Financing> financingsList = new ArrayList<>();

        // Solicitação de dados apenas para o primeiro financiamento
        System.out.println("Insira os dados do financiamento de casa fornecidos pelo usuário:");
        double propertyValue = userInterface.askPropertyValue();
        int financingPeriod = userInterface.askAnnualFinancingPeriod();
        double annualInterestRate = userInterface.askInterestRate();

        // Adicionar o financiamento fornecido pelo usuário
        Casa userCasa = new Casa(propertyValue, financingPeriod, annualInterestRate);
        financingsList.add(userCasa);

        // Adicionar os demais financiamentos diretamente no código
        // Financiamento 2 - Casa
        Casa casa2 = new Casa(300000, 25, 8.5);
        financingsList.add(casa2);

        // Financiamento 3 - Apartamento
        Apartamento apto1 = new Apartamento(400000, 20, 7.0);
        financingsList.add(apto1);

        // Financiamento 4 - Apartamento
        Apartamento apto2 = new Apartamento(500000, 30, 6.5);
        financingsList.add(apto2);

        // Financiamento 5 - Terreno
        Terreno terreno = new Terreno(200000, 15, 9.0);
        financingsList.add(terreno);

        // Exibição dos dados de todos os financiamentos
        for (Financing financing : financingsList) {
            financing.showFinancingData();
            System.out.println(); // Linha em branco para separar os financiamentos
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