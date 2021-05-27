package br.com.alura.threads2.tarefas;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {

  private Socket socket;
  private ServidorTarefas server;
  private ExecutorService threadPool;

  public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas server) {
    this.threadPool = threadPool;
    this.socket = socket;
    this.server = server;
  }

  @Override
  public void run() {

    System.out.println("Distribuindo tarefas para " + socket);



    try {

      Scanner entradaCliente = new Scanner(socket.getInputStream());

      PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

      while (entradaCliente.hasNextLine()) {
        String comando = entradaCliente.nextLine();

        switch (comando) {
          case "c1": {
            ComandoC1 c1 = new ComandoC1(saidaCliente);
            threadPool.execute(c1);
            saidaCliente.println("confirmacao comando c1");
            break;
          }

          case "c2": {
            ComandoC2 c2 = new ComandoC2(saidaCliente);
            threadPool.execute(c2);
            saidaCliente.println("confirmacao comando c2");
            break;
          }
          case "fim": {
            saidaCliente.println("fim, desligando sv");
            server.shutdown();
            break;
          }
          default: {
            saidaCliente.println("comando nao encontrado");
          }
            break;
        }

        System.out.println(comando);
      }

      saidaCliente.close();
      entradaCliente.close();

    } catch (Exception e) {
      throw new RuntimeException(e);
      // TODO Auto-generated catch block

    }

  }

}
