#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/toolkit/StringUtil.java
javac -cp bin -d bin src/toolkit/Calc.java
javac -cp bin -d bin src/toolkit/Dado.java
javac -cp bin -d bin src/toolkit/Dado6Faces.java
javac -cp bin -d bin src/toolkit/Dado18Faces.java
javac -cp bin -d bin src/toolkit/Main.java