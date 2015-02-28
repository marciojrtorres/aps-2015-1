#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/toolkit/Calc.java
javac -cp bin -d bin src/toolkit/Main.java