#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin:lib/jfugue-5.0.1.jar -d bin src/som/Main.java