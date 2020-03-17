# Java Exceptions and Errors

## Getting started

1. Create your own exception and add it to signature of `io.humb1t.Main.LifeCycleAction.execute`. 
    - Completed. (class LifeCycleExecutionMyOwnException)
1. Create your own implementation of `java.lang.AutoCloseable` interface. Test it.
    - Completed. (class MyOwnAutoCloseableImplementation instantiate in Main.main)
1. Create a new class. Implement constructor which should throw an exception during execution.
Write a simple program where you attempt to instantiate object of this class and assign it to a 
variable (declaration should be outside `try/catch` block). Catch an exception. Find out - what's
a value inside your variable. Write down your thoughts.
    - Answer: На этапе выполнения конструктора бросается исключение, выполнение программы 
прерывается, объект не создается, значение переменной не меняется (остается равным null).
