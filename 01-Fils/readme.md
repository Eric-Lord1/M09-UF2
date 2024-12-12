# Conclusions i Resultats

## Introducció
En aquesta pràctica he pogut veure com gestionar de forma bàsica dos fils en execució paral·lela, asignat diferentes prioritats.

## Resultats obtinguts

### Comportament 1
Hem configurat les prioritats dels fils amb `setPriority()`. Tot i que "Pepe" té una prioritat un poc més alta, no sempre s'executa de manera uniforme, perquè la JVM (Java Virtual Machine) no garanteix un ordre exacte. Un exemple de sortida pot ser:

```
Termina thread main
Juan 1
Juan 2
Juan 3
Pepe 1
Pepe 2
Pepe 3
Juan 4
Juan 5
Pepe 4
Pepe 5
Pepe 6
Juan 6
Pepe 7
Pepe 8
Pepe 9
Juan 7
Juan 8
Juan 9
Juan 10
Termina el fil Juan
Termina el fil Pepe
```

### Comportament 2
Li hem donat a "Pepe" la prioritat més alta (10) i a "Juan" la més baixa (1). Això fa que normalment "Pepe" acabi abans.

```
Termina thread main
Pepe 1
Pepe 2
Pepe 3
Pepe 4
Pepe 5
Pepe 6
Pepe 7
Pepe 8
Pepe 9
Pepe 10
Juan 1
Juan 2
Juan 3
Juan 4
Juan 5
Juan 6
Juan 7
Juan 8
Juan 9
Juan 10
Termina el fil Pepe
Termina el fil Juan
```

### Comportament 3

Li hem donat a "Pepe" prioritat (4) i a "Juan" (4). Això fa que s'intercali més o menys exacte.

```
Termina thread main
Juan 1
Pepe 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Juan 8
Pepe 8
Juan 9
Pepe 9
Termina el fil Pepe
Termina el fil Juan
```

## Conclusions
1. **Prioritats**: Les prioritats són útils per influir en l'ordre d'execució, però no són definitives.
2. **Resultats variables**: L'ordre pot variar d'una execució a una altra pel funcionament intern de la JVM.
