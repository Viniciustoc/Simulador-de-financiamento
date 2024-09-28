package Main;

import modelo.Casa;
import modelo.DescontoMaiorDoQueJurosException;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criação do objeto para interface do usuário
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicitação de dados para um financiamento fornecido pelo usuário (Casa)
        System.out.println("Insira os dados do financiamento (Casa):");
        double propertyValue = interfaceUsuario.askPropertyValue();
        int financingPeriod = interfaceUsuario.askAnnualFinancingPeriod();
        double annualInterestRate = interfaceUsuario.askInterestRate();
        double areaConstruida = 120.0;
        double tamanhoTerreno = 300.0;

        // Adicionar o financiamento fornecido pelo usuário (Casa)
        Casa userCasa = new Casa(propertyValue, financingPeriod, annualInterestRate, areaConstruida, tamanhoTerreno);

        // Tentar aplicar um desconto e capturar a exceção, se ocorrer
        try {
            System.out.println("Digite o valor do desconto: ");
            double desconto = Double.parseDouble(interfaceUsuario.scanner.nextLine());
            double parcelaComDesconto = userCasa.calculateMonthlyPaymentWithDiscount(desconto);
            System.out.println("Parcela mensal com desconto: R$" + parcelaComDesconto);
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Exibir os dados do financiamento
        userCasa.showFinancingData();
    }
}