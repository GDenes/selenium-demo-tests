@echo off
TITLE "Selenium HUB settings - create hub server"

SET PORT=
for %%i in (*.jar) do SET JARFILE=%%i

SET selenium_server_command=java
SET browser_settings=

goto getOpts

:getOpts
if /I "%1" == "-h" goto :Help
if /I "%1" == "-p" set PORT=%2 & shift
if /I "%1" == "-f" set JARFILE=%2 & shift
shift
if not "%1" == "" goto getOpts

call :setCommandVariablesAndCreateCommand

call :printSettings

%selenium_server_command%

:setCommandVariablesAndCreateCommand

if (%JARFILE% NEQ "") ( SET selenium_server_command=%selenium_server_command% -jar %JARFILE% -role hub)
if NOT DEFINED %JARFILE% ( call :fileError )

if NOT DEFINED %PORT% (SET selenium_server_command=%selenium_server_command%-port %PORT%)
goto :eof

:: Print set settings
:printSettings
echo.
echo ===========================================
echo SETTINGS
echo ===========================================
echo SELENIUM GRID  : %JARFILE%
echo PORT  : %PORT%
echo.

echo ===========================================
echo SELENIUM GRID - CREATE HUB COMMAND
echo ===========================================
echo %selenium_server_command%
echo.
goto :eof

::Help function
:Help
echo.
echo ===========================================
echo COMMAND PARAMETER HELP
echo ===========================================
echo [ -p ] - Hub server start up port
echo [ -f ] - Selenium standalone server ".jar" file path
echo.
goto :eof

:fileError
echo.
echo Please check current directory, because no have executable .jar file!
echo.
goto :Help