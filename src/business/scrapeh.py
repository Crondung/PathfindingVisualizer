import requests
from bs4 import BeautifulSoup

key = []

url = "http://api.nordenkel.de/"

page = requests.get(url)

soup = BeautifulSoup(page.content, 'html.parser')

first = soup.text[0:len(soup.text)//2]
second = soup.text[len(soup.text)//2:len(soup.text)]

for cf, cs in zip(first, second):
    if cf > cs:
        key.append(cf)
    else:
        key.append(cs)


answerToEverything = #TODO
vokale = [] #TODO

realkey = [x if x not in vokale else str(answerToEverything) for x in key]
#bisschen zu lang
realkey = realkey[3:14]
print(''.join(realkey))


