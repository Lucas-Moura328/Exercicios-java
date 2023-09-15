package br.com.lucas;

import jdk.dynalink.Operation;

import java.util.Scanner;
public class Calculadora {
    public double valor1;
    public double valor2;
    public double resultado;

    public double somar(){
        return resultado = valor1 + valor2;
    }
    public double subtrair(){
        return resultado = valor1 - valor2;
    }
    public double dividir(){
        return resultado = valor1 / valor2;
    }
    public double multiplicar(){
        return resultado = valor1 * valor2;
    }
    public void readValues() {
        Scanner sc = new Scanner(System.in);
        String operation;

        System.out.print("Entre com o primeiro valor: ");
        valor1 = sc.nextDouble();
        System.out.print("Entre com a operação: ");
        operation = sc.next();
        System.out.print("Entre com o segundo valor: ");
        valor2 = sc.nextDouble();

        switch (operation) {
            case "+":
                System.out.println("Resultado: " + somar()); break;
            case "-":
                System.out.println("Resultado: " + subtrair()); break;
            case "*":
                System.out.println("Resultado: " + multiplicar()); break;
            case "/":
                System.out.println("Resultado: " + dividir()); break;
            default:
                System.err.println("error operation");
        }

    }
}
