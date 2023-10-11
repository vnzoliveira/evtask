@echo off
::Configs
set TOMCAT_DIR=C:\Program Files\apache-tomcat-10.1.13
set APP_NAME=evtask
set WAR_PATH=%~dp0\target\evtask.war

::Copies the WAR folder to apache tomcat webapp folder
copy "%WAR_PATH%" "%TOMCAT_DIR%\webapps\%APP_NAME%.war"

::Start Tomcat
cd "%TOMCAT_DIR%\bin"
call startup.sh

::Wait tomcat to starts
timeout /t 5 /nobreak > nul

::Opens default browser with application
start http://localhost:8080/%APP_NAME%/

::Pauses to maintain CMD open
pause