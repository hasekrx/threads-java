package br.com.alura.threads2.tarefas.clientes;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

  public static void main(String[] args) throws Exception {

    Socket socket = new Socket("localhost", 12345);


    System.out.println("Conexao estabelecidade");

    Thread threadEnviaComando = new Thread(new Runnable() {

      @Override
      public void run() {

        try {
          PrintStream saida = new PrintStream(socket.getOutputStream());
          Scanner teclado = new Scanner(System.in);
          while (teclado.hasNextLine()) {
            String nextLine = teclado.nextLine();

            if (nextLine.trim().contentEquals("")) {
              break;
            }
            saida.println(nextLine);
          }

          teclado.close();
          saida.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

      }
    });


    Thread threadRecebeReposta = new Thread(new Runnable() {

      @Override
      public void run() {

        try {
          System.out.println("recebendo dados do sv");
          Scanner respostaServidor = new Scanner(socket.getInputStream());
          while (respostaServidor.hasNextLine()) {
            String nextLine = respostaServidor.nextLine();

            System.out.println(nextLine);

          }
          respostaServidor.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

      }
    });

    threadEnviaComando.start();
    threadRecebeReposta.start();

    threadEnviaComando.join();

    System.out.println("fechando socket");
    socket.close();
  }

}
