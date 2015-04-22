#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin:lib/commons-httpclient-3.1.jar -d bin src/cep/Main.java