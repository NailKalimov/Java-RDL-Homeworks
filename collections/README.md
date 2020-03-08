# Java Collections

## Getting started

1. Open `io.humb1t.Main.java` and compare different approaches in iterations. Write down your thoughts,
what is your favourite option? Which one is easier to read and which one is easier to write? Why?
    - Answer: по моему мнению for(Order order:orders){} самая удобная в написании и чтении конструкция 
для перебора элементов коллекции. Однако последний вариант цикла с использованием объекта Iterator 
позволяет безопасно изменять коллекции во время прохода по ним в цикле. Потоки для меня новая тема, поэтому 
в моих глазах они еще выглядят немного диковато, но я постепенно проникаюсь лаконичностю их синтаксиса.
1. Add numeric field to `Order` class, use it to filter collection of orders by some criteria 
(more than 50 order items for example).
1. Imagine the situation - you need to implement [queue](https://en.wikipedia.org/wiki/Queue_(abstract_data_type\))
of incoming requests, to process incoming requests we have 3 independent "processors".
How can we design our application in such a case and what pros and cons we would face in different approaches?
Write down your thoughts and implement one possible solution.
    - Answer: Я буду использовать ConcurrentLinkedQueue, т.к. это потокобезопасная версия очереди.
1. Imagine the situation when you have a `Collection` and should remove all duplicates in it. 
How would you do it? Implement your solution using only Java SE.
    - Answer: Это можно сделать переместив содержимое исходной коллекции в HashSet или LinkedHashSet, если важен порядок,
    предварительно убедившись в правильной реализации equals и hashCode. Также можно использовать Stream.
    Реализацию последнего варианта можно найти в классе Task4.
1. There is an old war between `ArrayList` and `Linked List` - choose new fighters and implement your
own benchmark (`Vector` vs `Queue` for example). Write down your thoughts.
    - Answer: Implementation is in package war
1. `Map` is very good in implementation of simple [caches](https://en.wikipedia.org/wiki/Cache_(computing\)).
Implement your own cache using `Map`.
    - Answer: I have implemented LRU Cache. You can find implementation in package simpleCacheImplementation. 

