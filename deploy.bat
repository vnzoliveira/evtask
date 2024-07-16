@echo off

cd /d %~dp0

call mvnw.cmd clean package

setlocal enabledelayedexpansion
set "CLASSPATH=target\evtask\WEB-INF\classes"
for %%i in (target\evtask\WEB-INF\lib\*.jar) do (
    set "CLASSPATH=!CLASSPATH!;%%i"
)

start java -cp "!CLASSPATH!" com.evtask.myproject.main.Main

timeout /t 5 /nobreak

start "" "http://localhost:8080"

endlocal
