# Preguntes teòriques  
1. Per què s'atura l'execució al cap d'un temps? 
Resposta:  arriba un moment en la que tots els fils queden en wait(), llavors el programa no pot avancar perque no hi ha ningu que els desperti.

2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% 
(cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos 
Respota: 

    Si la probabilitat es major de fer reserva que de no la llista s'ompli abans per tant abans es queda parat el programa.
        if (Math.random() < 0.3) {
                    if (this.esdeveniment.ferReserva(this))
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-0 ha fet una reserva. Places disponibles: 3
Assistent-0 s'ha cancelat una reserva. Places disponibles: 4
Assistent-0 ha fet una reserva. Places disponibles: 3
Assistent-0 ha fet una reserva. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-0 s'ha cancelat una reserva. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-0 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-9 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 0
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 0
Assistent-1 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-6 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-5 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 0
Assistent-4 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-3 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-2 no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: 0
Assistent-0 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-9 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
        
    Si la probabilitat es menor doncs al reves.
        if (Math.random() < 0.3) {
                    if (this.esdeveniment.ferReserva(this)) {
Assistent-8 ha fet una reserva. Places disponibles: 4
Assistent-8 s'ha cancelat una reserva. Places disponibles: 5
Assistent-8 ha fet una reserva. Places disponibles: 4
Assistent-8 s'ha cancelat una reserva. Places disponibles: 5
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-7 ha fet una reserva. Places disponibles: 4
Assistent-7 ha fet una reserva. Places disponibles: 3
Assistent-7 s'ha cancelat una reserva. Places disponibles: 4
Assistent-7 s'ha cancelat una reserva. Places disponibles: 5
Assistent-7 ha fet una reserva. Places disponibles: 4
Assistent-7 ha fet una reserva. Places disponibles: 3
Assistent-7 s'ha cancelat una reserva. Places disponibles: 4
Assistent-7 s'ha cancelat una reserva. Places disponibles: 5
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-6 ha fet una reserva. Places disponibles: 4
Assistent-6 ha fet una reserva. Places disponibles: 3
Assistent-6 s'ha cancelat una reserva. Places disponibles: 4
Assistent-6 ha fet una reserva. Places disponibles: 3
Assistent-6 ha fet una reserva. Places disponibles: 2
Assistent-6 s'ha cancelat una reserva. Places disponibles: 3
Assistent-6 s'ha cancelat una reserva. Places disponibles: 4
Assistent-6 s'ha cancelat una reserva. Places disponibles: 5
Assistent-6 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-5 ha fet una reserva. Places disponibles: 4
Assistent-5 s'ha cancelat una reserva. Places disponibles: 5
Assistent-5 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-4 ha fet una reserva. Places disponibles: 4
Assistent-4 s'ha cancelat una reserva. Places disponibles: 5
Assistent-4 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-3 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-2 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-1 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-5 ha fet una reserva. Places disponibles: 4
Assistent-5 s'ha cancelat una reserva. Places disponibles: 5
Assistent-5 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-6 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-9 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-0 s'ha cancelat una reserva. Places disponibles: 5
Assistent-0 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-1 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-2 s'ha cancelat una reserva. Places disponibles: 5
Assistent-2 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-3 ha fet una reserva. Places disponibles: 4
Assistent-3 ha fet una reserva. Places disponibles: 3
Assistent-3 ha fet una reserva. Places disponibles: 2
Assistent-3 s'ha cancelat una reserva. Places disponibles: 3
Assistent-3 ha fet una reserva. Places disponibles: 2
Assistent-3 ha fet una reserva. Places disponibles: 1
Assistent-3 s'ha cancelat una reserva. Places disponibles: 2
Assistent-3 s'ha cancelat una reserva. Places disponibles: 3
Assistent-3 s'ha cancelat una reserva. Places disponibles: 4
Assistent-3 s'ha cancelat una reserva. Places disponibles: 5
Assistent-3 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-4 ha fet una reserva. Places disponibles: 4
Assistent-4 s'ha cancelat una reserva. Places disponibles: 5
Assistent-4 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-2 s'ha cancelat una reserva. Places disponibles: 5
Assistent-2 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-1 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-0 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-9 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-6 ha fet una reserva. Places disponibles: 4
Assistent-6 ha fet una reserva. Places disponibles: 3
Assistent-6 s'ha cancelat una reserva. Places disponibles: 4
Assistent-6 s'ha cancelat una reserva. Places disponibles: 5
Assistent-6 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-5 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-8 ha fet una reserva. Places disponibles: 4
Assistent-8 s'ha cancelat una reserva. Places disponibles: 5
Assistent-8 ha fet una reserva. Places disponibles: 4
Assistent-8 s'ha cancelat una reserva. Places disponibles: 5
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-9 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-0 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-1 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-2 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-4 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-3 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-7 ha fet una reserva. Places disponibles: 4
Assistent-7 s'ha cancelat una reserva. Places disponibles: 5
Assistent-7 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-5 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-6 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-3 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-4 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-2 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-1 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-0 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-9 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
Assistent-8 no s'ha pogut cancelar una reserva inexsistent. Places disponibles: 5
            
3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves? 
Respota: perque volem que la simulacio tingui un limit i que es pugui interactuar amb ella.