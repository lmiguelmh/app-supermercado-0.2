@echo off
pushd .

rem EXECUTE MAVEN GOALS
rem call mvn clean 
call mvn package
if %errorlevel% neq 0 goto :error

rem COPY H2 DATABASE IF DOESN'T EXISTS
if not exist ./target/sm-1.0.mv.db copy sm-1.0.mv.db .\target\

rem EXECUTE JAVA JAR
cd target
java -jar app-supermercado-1.1.8.RELEASE.jar
if %errorlevel% neq 0 goto :error
goto :exit

:error
echo An error has ocurred!
pause

:exit
popd

