package br.com.alura.threads2.tarefas;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

  private PrintStream saidaCliente;

  public ComandoC2ChamaWS(PrintStream saidaCliente) {
    this.saidaCliente = saidaCliente;
  }

  @Override
  public String call() throws Exception {
    System.out.println("executando comando c2 - WS");

    System.out.println("processando comando c2 - WS");

    Thread.sleep(12000);

    Integer numero = new Random().nextInt(100) - 1;

    System.out.println("comando c2 executado com sucesso - WS!");

    return numero.toString();
  }

}
