[Netsh AdvFirewall Firewall Commands](http://winintro.ru/netsh_technicalreference.en/html/1a736f2d-ecf8-4780-8e0f-85c4db75230b.htm)
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


netsh advfirewall firewall delete rule profile=domain,private name="Test"
Deleted 1 rule(s).
Ok.
```

# set( update) rule
```
C:\Windows\system32>netsh advfirewall firewall set rule name=wechat new enable=no

Updated 1 rule(s).
Ok.


C:\Windows\system32>netsh advfirewall firewall show rule name=wechat

Rule Name:                            WeChat
----------------------------------------------------------------------
Enabled:                              No
Direction:                            In
Profiles:                             Domain,Private,Public
Grouping:
LocalIP:                              Any
RemoteIP:                             Any
Protocol:                             Any
Edge traversal:                       No
Action:                               Allow
Ok.

```
# open the ICMP
```
#if ping can't reach
netsh advfirewall firewall set rule name="File and Printer Sharing (Echo Request - ICMPv4-In)" new enable=yes

Updated 2 rule(s).
Ok.
netsh advfirewall firewall set rule name="File and Printer Sharing (Echo Request - ICMPv4-Out)" new enable=yes

Updated 2 rule(s).
Ok.

```
