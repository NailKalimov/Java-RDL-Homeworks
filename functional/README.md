# Java 8 and functional programming

## API and Optional

1. Modify your `CacheReturnedOption.Cache` from previous task and return `Optional#empty` instead of `null` if 
element is missing. 
1. We use `Optional` for return values, is it a good idea to use it as incoming parameters?
Write down your thoughts.
    - Answer: Использование Optional, как incoming parameters, не рекоммендовано, на сколько я понял, 
    т.к. Optional - это боксинг, а значит требует дополнительных ресурсов. Да и сами разработчики
    рекомендуют использовать Optional крайне осторожно и не пытаться заменить им все обьекты, которые
    могут быть null-ом. 

## Method references and Streams

1. Modify your `MethodReferencesAndStreamsHomework.Order` class, create method which would return `boolean` depends on the value of
numeric field (which was added in previous task).
    - Completed. Added method priceInOrderMoreThan in src/MethodReferencesAndStreamsHomework/Order
1. Modify your filter algorithm, use new method and `Streams API`.
    - Completed. (see MethodReferencesAndStreamsHomework.Main)
## Default methods

1. Create new interface called `OrderFactory`. Interface should provide methods for 
creation of `Orders` with different `OrderStatuses`. For each status create `default` method.
What method should provide implementation of this interface? Write your own implementation.
