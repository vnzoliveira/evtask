@echo off
::Configs
set TOMCAT_DIR=C:\Program Files\apache-tomcat-10.1.13

::Shuts down Tomcat server
cd "%TOMCAT_DIR%\bin"
call shutdown.bat