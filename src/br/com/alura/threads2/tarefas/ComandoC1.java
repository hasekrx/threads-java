package br.com.alura.threads2.tarefas;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

  private PrintStream saidaCliente;

  public ComandoC1(PrintStream saidaCliente) {
    this.saidaCliente = saidaCliente;
  }

  @Override
  public void run() {
    System.out.println("executando comando c1");

    try {
      Thread.sleep(12000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("comando c1 executado com sucesso!");

  }

}
