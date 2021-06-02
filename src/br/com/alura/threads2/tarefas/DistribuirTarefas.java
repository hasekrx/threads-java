package br.com.alura.threads2.tarefas;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

  private Socket socket;
  private ServidorTarefas server;
  private ExecutorService threadPool;
  private BlockingQueue<String> filaComandos;

  public DistribuirTarefas(ExecutorService threadPool, BlockingQueue<String> filaComandos,
      Socket socket, ServidorTarefas server) {
    this.threadPool = threadPool;
    this.socket = socket;
    this.server = server;
    this.filaComandos = filaComandos;
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
            ComandoC2ChamaWS c2 = new ComandoC2ChamaWS(saidaCliente);
            ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);
            Future<String> futureWS = threadPool.submit(c2);
            Future<String> futureBanco = threadPool.submit(c2Banco);

            this.threadPool.submit(new JuntaFuturesWsAndBanco(futureWS, futureBanco, saidaCliente));

            break;
          }

          case "c3": {
            this.filaComandos.put(comando); // block the thread
            saidaCliente.println("comando c3 adicionado na fila");

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
