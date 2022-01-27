# POSSystem
A lightweight, property-mapping and recalling, POS-System, developed in Java

# Installation
1. Open the project in your favorite Java IDE
2. Add all the items (products) you want to store in the `registerItems()` method of the `POSSystem`-Class (SEE #Construction)
3. Construct all the properties for your items using the example constructor
4. Compile and run the program

# Example
PS: This is in the `POSSystem` Class
```java
private void registerItems() {
      registerItem("some Product_1", mapper.new PropertyContainer("someProperty", "someValue"), mapper.new PropertyContainer("anotherProperty", "anotherValue"));
      registerItem("some-Product 2", mapper.new PropertyContainer("weight (pounds)", 8.6f), mapper.new PropertyContainer("height", "54cm"));
}
```

# Construction
The `PropertyContainer`-Clas Constructor is `new PropertyContainer("key", "value")`
