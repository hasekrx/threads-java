package br.com.alura.threads2.tarefas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {


  private ServerSocket server;
  private ExecutorService threadPool;
  private AtomicBoolean isRunning;

  public ServidorTarefas() throws IOException {
    System.out.println("--------- Iniciando Servidor ----");
    this.server = new ServerSocket(12345);
    this.threadPool = Executors.newCachedThreadPool();
    this.isRunning = new AtomicBoolean(true);
  }

  public static void main(String[] args) throws Exception {

    ServidorTarefas servidor = new ServidorTarefas();
    servidor.run();
    servidor.shutdown();

  }

  public void run() throws IOException {
    while (this.isRunning.get()) {
      try {
        Socket socket = server.accept();
        System.out.println("Aceitando novo cliente na porta " + socket.getPort());
        DistribuirTarefas distribuir = new DistribuirTarefas(socket, this);
        threadPool.execute(distribuir);
      } catch (SocketException e) {
        System.out.println("SocketException, está rodando? " + this.isRunning);
      }
    }

  }

  public void shutdown() throws IOException {
    server.close();
    threadPool.shutdown();
    this.isRunning.set(false);
  }



}
