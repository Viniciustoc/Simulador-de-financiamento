package util;

import java.util.Scanner;

public class InterfaceUsuario {
    public Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double askPropertyValue() {
        double propertyValue = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                propertyValue = Double.parseDouble(scanner.nextLine());
                if (propertyValue <= 0) {
                    throw new IllegalArgumentException("O valor do imóvel deve ser maior que zero.");
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para o valor do imóvel.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return propertyValue;
    }

    public int askAnnualFinancingPeriod() {
        int financingPeriod = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite o período de financiamento em anos: ");
                financingPeriod = Integer.parseInt(scanner.nextLine());
                if (financingPeriod <= 0) {
                    throw new IllegalArgumentException("O período de financiamento deve ser maior que zero.");
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para o período de financiamento.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return financingPeriod;
    }

    public double askInterestRate() {
        double interestRate = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Digite a taxa de juros anual: ");
                interestRate = Double.parseDouble(scanner.nextLine());
                if (interestRate <= 0) {
                    throw new IllegalArgumentException("A taxa de juros deve ser maior que zero.");
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para a taxa de juros.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return interestRate;
    }
}