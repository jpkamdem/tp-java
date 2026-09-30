### Question README : pourquoi un setter setPv(int pv) casserait-il l'encapsulation même s'il vérifie les bornes ?

L'encapsulation consiste à permettre à une classe de s'autogérer, et de ne pas permettre d'intrusion.

```java
combattant.setPv = 30
```

Cette opération est impossible puisque `pv` est <i>private</i>, alors que :

```java
monCombattant.damaeg(30)
```

Ici, la classe est responsable de ses propres changements.

### Question README : dans Combattant c = new Mage(...); c.attaquer(x); , quelle méthode est appelée et pourquoi ? Expliquez la différence entre type déclaré et type réel.

C'est la méthode définie dans `Mage.class` qui est appelé, puisque c'est une méthode abstraite qui est définie par les classes enfants.
Le type déclaré correspond au type spécifié lors de l'initialisation de la variable, alors que le type réel fait référence au type de l'objet lorsqu'il est instancié au démarrage du programme.