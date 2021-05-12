package br.com.alura.threads.bathroom;

public class Bathroom {

  public void number1() {

    String nome = Thread.currentThread().getName();
    System.out.println(nome + " Knocking the door ");

    synchronized (this) {

      System.out.println(nome + " enter the bathroom");

      System.out.println(nome + " Using");

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(nome + " Flushing");

      System.out.println(nome + " Leaving Bathroom");

    }
  }


  public void number2() {

    String nome = Thread.currentThread().getName();
    System.out.println(nome + " Knocking the door ");

    synchronized (this) {

      System.out.println(nome + " enter the bathroom");

      System.out.println(nome + " Using for more time");

      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(nome + " Flushing");

      System.out.println(nome + " Leaving Bathroom");

    }
  }

}
