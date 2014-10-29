app-supermercado-0.2
====================

A simple Java Swing application that uses spring-boot, generics and the h2 database engine. For the "PUCP Curso de Especialización 2014-II - Paradigmas de programación y bases de datos". Developed in IntelliJ Idea.

For testing purposes you need to have Maven3 installed and configured.

*Windows*

    cd app-supermercado-0.2
    mvn clean package
	copy sm-1.0.mv.db .\target\
    cd target
    java -jar app-supermercado-1.1.8.RELEASE.jar

**IMPORTANT**

*Copy the H2 database `sm-1.0.mv.db` to the directory where the app-supermercado-1.1.8.RELEASE.jar is. If you are using `exec.bat` this database file will be copied automatically.*

