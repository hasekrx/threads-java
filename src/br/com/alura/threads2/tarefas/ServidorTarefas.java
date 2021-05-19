package br.com.alura.threads2.tarefas;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

  public static void main(String[] args) throws Exception {

    System.out.println("--------- Iniciando Servidor ----");

    ServerSocket server = new ServerSocket(12345);

    ExecutorService threadPool = Executors.newCachedThreadPool();

    while (true) {
      Socket socket = server.accept();
      System.out.println("Aceitando novo cliente na porta " + socket.getPort());

      DistribuirTarefas distribuir = new DistribuirTarefas(socket);
      threadPool.execute(distribuir);
    }



  }

}
