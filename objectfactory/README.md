# Java Object Factory

## Factory class

`ObjectFactory` class provides the factory class for creating objects.
Shifting the responsibility of creating new objects to a factory
class makes mocking and stubbing of the dependant classes easier.

```java
Person person = ObjectFactory.build(Person.class)
                  .withTypes(String.class, int.class)
                  .withArgs("John Doe", 29)
                  .create();
```
## build method

In the above example the `build` method ensures the factory knows which class
object shall be created and hence necessary.

## Argument methods

The methods `withTypes` and `withArgs` can accept multiple parameters and 
describe the constructor to be used and the arguments types and 
actual argument values to be used to create the object.

## create method

The `create` method actually creates the object using all configuration passed to the factory using other methods.