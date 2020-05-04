@echo off
# loop open file
REM open all file with .\*"Image Parameter Setting.ini"

for /f "delims=xxx" %%a in ('dir /B /O:-N .\*"Image Parameter Setting.ini"  /S') do (

REM echo %%a

start Notepad++ %%a

)

REM force kill program Whale.exe

Taskkill /IM Whale.exe /F

del /F /S /Q *.raw

# shutdown and schedule
::cancel cmd

shutdown.exe -a

::shut down in X second

shutdown.exe -s -t X 

::Scheduled Job/Task

SCHTASKS /Create /ST 22:00:00 /SC ONCE /TN "howard" /TR "shutdown -s -f -t 30"

::find the scheduled task with name howard

schtasks /Query /TN howard

schtasks | find /i "how"

::Delete the task

SCHTASKS /Delete /TN "howard"


# while

:: :~3,4 data position 3 get 4 => [3:7]

:While

::cls

set sysTime=%Time:~6,2%

::if time(second) bigger than 50 or equal to 36 goto endWhile

if %sysTime% == 36 (

goto endWhile

)

if %sysTime% gtr 50 (

goto endWhile

)

timeout 1

goto While

:EndWhile

::EQU - equal

::NEQ - not equal

::LSS - less than

::LEQ - less than or equal

::GTR - greater than

::GEQ - greater than or equal

# ProxyNetAdapt ON/OFF

## ON


@echo off

reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyEnable /t REG_DWORD /d 1

REM reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyServer /t REG_SZ /d 10.57.65.74:5555

REM reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyUser /t REG_SZ /d username

REM reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyPass /t REG_SZ /d password




netsh interface ip set address "RealtekUSB" static 10.185.9.156 255.255.252.0 10.185.8.1 1

netsh interface ip set dnsservers "RealtekUSB" static 10.185.8.80

netsh interface ip add dnsservers "RealtekUSB" 10.185.8.81

netsh interface ip set winsservers "RealtekUSB" static 192.168.1.1

pause

## OFF
@echo off

reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyEnable /t REG_DWORD /d 0

netsh winhttp reset proxy

netsh interface ip set address "RealtekUSB" dhcp

netsh interface ip set dnsservers "RealtekUSB" dhcp

netsh interface ip set winsservers "RealtekUSB" dhcp

pause

