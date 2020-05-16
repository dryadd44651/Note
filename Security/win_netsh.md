# add, show, delete firewall rule
```
C:\Windows\system32>netsh advfirewall firewall add rule name="Test" profile=domain,private protocol=any enable=yes DIR=In program="C:\Program Files (x86)\Tencent\WeChat\WeChat.exe" Action=Allow
Ok.


C:\Windows\system32>netsh advfirewall firewall show rule name=test

Rule Name:                            Test
----------------------------------------------------------------------
Enabled:                              Yes
Direction:                            In
Profiles:                             Domain,Private
Grouping:
LocalIP:                              Any
RemoteIP:                             Any
Protocol:                             Any
Edge traversal:                       No
Action:                               Allow
Ok.
```
