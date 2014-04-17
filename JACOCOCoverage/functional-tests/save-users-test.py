#!/usr/bin/python
import httplib
import urllib2
import json
headers = {'content-type':'application/json','accept':'application/json'}
data=[{'userName':'itsvenkis','password':'password','firstName':'venkat','lastName':'Nanda'}]
data=json.dumps(data)
url="http://192.168.2.5:8080/jacoco-coverage/itsvenkis/user-management/save-users"
req=urllib2.Request(url,data,headers)
conn=urllib2.urlopen(req)
response=conn.read()
conn.close()
print "done";
