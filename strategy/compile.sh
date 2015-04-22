#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/game/Personagem.java
javac -cp bin -d bin src/game/GameSimulador.java
javac -cp bin -d bin src/game/Main.java