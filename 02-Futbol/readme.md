# Projecte Futbolista en Java

Aquest projecte és una simulació en Java d'un conjunt de futbolistes que realitzen tirades a porteria, amb resultats aleatoris. Es fa ús de fils (threads) per simular les accions de cada futbolista.

## Descripció de les classes

### 1. `Main`
Aquesta classe conté el mètode `main` principal per executar la simulació. Els passos són els següents:

1. Es defineixen els noms dels futbolistes en un array de noms.
2. Es crea un array d'objectes de la classe `Futbolista`.
3. Cada objecte `Futbolista` es configura amb un nom i es llança com un fil.
4. Finalment, es mostren les estadístiques dels gols marcats per cada futbolista.

### 2. `Futbolista`
Aquesta classe extén `Thread` i representa un jugador que:

- Pot fer un màxim de 20 tirades.
- Té una probabilitat del 50% de marcar en cada tirada.

### 3. `MainDemoFil`
Aquesta classe és una demostració de com funcionen els fils en Java:

- Mostra la prioritat i el nom del fil actual.
- Mostra informació general sobre el fil utilitzant el mètode `toString()`.

#### Mètodes principals:

- `run()`: Simula les tirades del jugador, incrementant el nombre de gols si s'encerta.
- `getGols()`: Retorna el nom del jugador i el nombre de gols marcats.

## Funcionament del programa

1. S'executa la classe `Main`.
2. Es crea un conjunt de 11 futbolistes que simulen tirades a porteria de forma independent.
3. Quan tots els fils han acabat, es mostren les estadístiques dels gols marcats per cada futbolista.

## Exemple d'output

```plaintext
Inici dels xuts --------------------
Fi dels xuts -----------------------
--- Estadístiques ------
CR7  ->  10 gols
Pique  ->  9 gols
Messi  ->  13 gols
...
Gavi  ->  11 gols
```

