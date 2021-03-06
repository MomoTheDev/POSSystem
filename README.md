# POS-System
A lightweight, property-mapping and recalling POS-System, developed in Java

# Installation
1. Open the project in your favorite Java IDE
2. Add all the items (products) you want to store, in the `registerItems()` method of the `POSSystem`-Class
3. Construct all the properties for your items using the example constructor
4. Compile and run the program

# Example
PS: This is in the `POSSystem` Class
```java
private void registerItems() {
      registerItem("some-Product 1", mapper.new PropertyContainer("someProperty", "someValue"), mapper.new PropertyContainer("anotherProperty", "anotherValue"));
      registerItem("some-Product 2", mapper.new PropertyContainer("weight (pounds)", 8.6f), mapper.new PropertyContainer("height", "54cm"));
}
```

Output for 1st Item/Product:
```log
[POS] > some product 1


[POS] Properties of Item: some-product 1
[POS] [anotherProperty : anotherValue]
[POS] [someProperty : someValue]
```

Output for 2nd Item/Product:
```log
[POS] > some product 2


[POS] Properties of Item: some-product 2
[POS] [weight (pounds) : 8.6]
[POS] [height : 54cm]
```


# Updating
I have enough time to manage this project by my own, you can suggest me some features you'd like or maybe report some bugs as well.
You can give suggestions and report bugs to me via Discord (MomoTheSiM#6478).

# Construction
The `PropertyContainer`-Class Constructor is `new PropertyContainer("key", "value")`
