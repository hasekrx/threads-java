package br.com.alura.threads.numbers;

public class NumersPrincipal {

  public static void main(String[] args) {
    Thread run1000numbers = new Thread(new RunAllNumbers(1, 1000), "Run AlL numbers 01");
    Thread run1000numbers2 = new Thread(new RunAllNumbers(1, 1000), "Run AlL numbers 02");

    run1000numbers.start();
    run1000numbers2.start();
  }

}
