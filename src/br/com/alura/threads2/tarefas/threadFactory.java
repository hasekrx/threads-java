package br.com.alura.threads2.tarefas;

import java.util.concurrent.ThreadFactory;

public class threadFactory implements ThreadFactory {

  private static int n = 1;

  @Override
  public Thread newThread(Runnable r) {

    Thread thread = new Thread(r, "thread number" + n);
    n++;
    thread.setUncaughtExceptionHandler(new ExceptionHandler());

    return thread;
  }

}
