package br.com.alura.threads2.tarefas;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("exception on thread " + t.getName() + ", " + e.getMessage());

  }

}
