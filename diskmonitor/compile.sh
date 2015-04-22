#!/bin/sh
rm -rf bin
mkdir bin
javac -cp bin -d bin src/diskmonitor/ShowFreeSpace.java
javac -cp bin -d bin src/diskmonitor/PrintFreeSpace.java
javac -cp bin -d bin src/diskmonitor/PrintFreeSpaceEnhanced.java
javac -cp bin -d bin src/diskmonitor/DiskMonitor.java
javac -cp bin -d bin src/diskmonitor/Main.java