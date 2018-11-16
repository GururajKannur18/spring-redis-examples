# spring-redis-examples

#Showing ways to import data into Redis using windows `redis-cli`

first make sure to set env variables

```
export PATH=$PATH:/c/Redis-x64-3.2.100
```

data.csv

```
CustId,FirstName,LastName,EmailId,Phone,Designation,Location
1,John,Doe,john.doe@gmail.com,+44-9090909099,Technical Architect,VA
2,Anthony,Ferguson,Anthony.Ferguson@gmail.com,+44-9090909090,Software Developer,London
3,Doris,Thornton,Doris.Thornton@gmail.com,+44-9090909091,Technical-Architect,Rome
4,Denise,Crawford,Denise.Crawford@gmail.com,+44-9090909092,Technical-Architect,Amaravati
5,Michele,Carson,Michele.Carson@gmail.com,+44-9090909093,Technical-Architect,CA
6,Robert,Robertson,Robert.Robertson@gmail.com,+44-9090909094,Technical-Architect,Rome
7,Jane,Wang,Jane.Wang@gmail.com,+44-9090909095,Technical-Architect,Paris
8,William,Baxter,William.Baxter@gmail.com,+44-9090909096,Technical-Architect,Chennai
```

Execute below commands

```
tail -n +2 data.csv | awk -F',' '{print "SET \""$1"\" \""$0"\""}' | redis-cli
```

