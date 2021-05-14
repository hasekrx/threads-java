package br.com.alura.threads.bathroom;

public class TaskClean implements Runnable {

  private Bathroom bathroom;

  public TaskClean(Bathroom bathroom) {
    super();
    this.bathroom = bathroom;
  }


  @Override
  public void run() {

    while (true) {
      bathroom.clean();

      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

}
