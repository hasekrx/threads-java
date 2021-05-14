package br.com.alura.threads.bathroom;

public class Bathroom {

  private boolean isDirty = true;

  public void number1() {

    String nome = Thread.currentThread().getName();
    System.out.println(nome + " Knocking the door ");

    synchronized (this) {

      System.out.println(nome + " enter the bathroom");

      while (isDirty) {
        waitOutside(nome);
      }

      System.out.println(nome + " Using");

      sleep(5000);

      isDirty = true;

      System.out.println(nome + " Flushing");

      System.out.println(nome + " Leaving Bathroom");

    }
  }


  public void number2() {

    String nome = Thread.currentThread().getName();
    System.out.println(nome + " Knocking the door ");

    synchronized (this) {

      System.out.println(nome + " enter the bathroom");

      while (isDirty) {
        waitOutside(nome);
      }

      System.out.println(nome + " Using for more time");

      sleep(10000);

      isDirty = true;

      System.out.println(nome + " Flushing");

      System.out.println(nome + " Leaving Bathroom");

    }
  }


  private void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void clean() {

    String nome = Thread.currentThread().getName();
    System.out.println(nome + " Knocking the door ");

    synchronized (this) {

      if (!isDirty) {
        System.out.println(nome + " bathroom is not dirty, leaving");
        return;
      }

      System.out.println(nome + " enter the bathroom");

      System.out.println(nome + " cleaning the bathroom");

      this.isDirty = false;

      try {
        Thread.sleep(8000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      this.notifyAll();

    }
  }

  private void waitOutside(String nome) {
    System.out.println(nome + " this bathroom is dirty");
    try {
      this.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
