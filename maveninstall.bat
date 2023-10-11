@echo off
setlocal

rem Path to pom.xml project
set POM_XML_PATH=%~dp0\pom.xml

rem Execute mvn command to build project
mvn -f "%POM_XML_PATH%" clean install

echo.
echo Maven Project built!
echo.

endlocal