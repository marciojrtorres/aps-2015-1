#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/ava/Financiamento.java
javac -cp bin -d bin src/ava/Main.java