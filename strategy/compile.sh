#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/game/Personagem.java src/game/Ataque.java
javac -cp bin -d bin src/game/Soco.java src/game/SemAtaque.java
javac -cp bin -d bin src/game/GameSimulador.java
javac -cp bin -d bin src/game/Main.java