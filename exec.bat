@echo off
pushd .
rem call mvn clean 
call mvn package
if %errorlevel% neq 0 goto :error
cd target
java -jar app-supermercado-1.1.8.RELEASE.jar
if %errorlevel% neq 0 goto :error
goto :exit

:error
echo An error has ocurred!
pause

:exit
popd

