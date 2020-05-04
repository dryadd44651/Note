import datetime
import time
import itchat, time
from itchat.content import *

#@itchat.msg_register([TEXT, MAP, CARD, NOTE, SHARING])
#def text_reply(msg):
#    msg.user.send('%s: %s' % (msg.type, msg.text))

#@itchat.msg_register([PICTURE, RECORDING, ATTACHMENT, VIDEO])
#def download_files(msg):
#    msg.download(msg.fileName)
#    typeSymbol = {
#        PICTURE: 'img',
#        VIDEO: 'vid', }.get(msg.type, 'fil')
#    return '@%s@%s' % (typeSymbol, msg.fileName)

#@itchat.msg_register(FRIENDS)
#def add_friend(msg):
#    msg.user.verify()
#    msg.user.send('Nice to meet you!')

#@itchat.msg_register(TEXT, isGroupChat=True)
#def text_reply(msg):
#    if msg.isAt:
#        msg.user.send(u'@%s\u2005I received: %s' % (
#            msg.actualNickName, msg.text))


print()
itchat.auto_login(hotReload=True)
#itchat.send('Hello, filehelper', toUserName='filehelper')
#itchat.run(True)

users=itchat.search_friends("Maeve")
userName= users[0]['UserName']
print(userName)
hours = datetime.datetime.now().strftime("%H")
mins = datetime.datetime.now().strftime("%M")
while True:
    if True:#int(hours) >7 and int(hours) <24 and int(mins) <100:
        #itchat.send('hi',toUserName=userName)
        itchat.auto_login(hotReload=True)
        hours = datetime.datetime.now().strftime("%H")
        mins = datetime.datetime.now().strftime("%M")
        itchat.send(hours+"_"+mins, toUserName='filehelper')
        time.sleep(420)
    time.sleep(600)
        
    
    
    

