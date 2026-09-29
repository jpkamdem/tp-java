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