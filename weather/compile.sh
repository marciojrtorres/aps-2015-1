#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin:lib/httpclient-4.4.1.jar:lib/httpcore-4.4.1.jar -d bin src/weather/Main.java