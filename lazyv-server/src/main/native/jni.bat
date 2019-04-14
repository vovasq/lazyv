@echo off
REM javac -h . NativeEasyKeySender.java
g++ -c -I "C:\Program Files\Java\jdk1.8.0_161\include" -I "C:\Program Files\Java\jdk1.8.0_161\include\win32" com_vovas_lazyv_server_NativeEasyKeySender.cpp -o native.o
g++ -W -shared -o ../resources/dll/native.dll native.o
REM del native.o
REM javac *.java -d .
REM java -cp . -Djava.library.path=Y:\5_course\os\cursach\lazyv\lazyv-server\src\main\java\com\vovas\lazyv\server com.vovas.lazyv.server.LazyvApp