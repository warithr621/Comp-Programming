import requests
import json
import time
f = open("woot.txt", "w") #cache for the users in case something breaks

superj6orz = json.loads(requests.get('https://codeforces.com/api/user.rating?handle=SuperJ6').content.decode())['result']
ratedlist = json.loads(requests.get('https://codeforces.com/api/user.ratedList?activeOnly=false&includeRetired=false').content.decode())['result']

contests = set() #all the contests superj6 has participated in
for d in superj6orz:
	contests.add(d['contestId'])
print(len(contests))

users = [] # users with rating in the interval [1600, 2400]
for d in ratedlist:
	if d['rating'] >= 1600 and d['rating'] <= 2400:
		# print(d['handle'])
		users.append(d['handle'])
print(len(users))

valid = [] #people in 'users' that have not participated in a contest w/ superj6

for i in range(len(users)):
	while True:
		try:
			s = 'https://codeforces.com/api/user.rating?handle=' + users[i]
			query = json.loads(requests.get(s).content.decode())['result']
			same = False #this will be true if 'users[i]' has participated in the same contest as jason
			old = True #this will be true if 'users[i]'s last contest was before jason's first
			
			for d in query:
				same |= d['contestId'] in contests
				old &= d['contestId'] <= 1183
				
			if not same and not old:
				valid.append(users[i])
				print(users[i])
				f.write(users[i] + '\n')
				f.flush()
			time.sleep(0.5)
			break
		except:
			pass
print(len(valid))


# what this does is first create a set 'contests' with all the contests SuperJ6 has participated in

# we then make a list 'users', which has every user in the interval [1600, 2400]
	# we decided this was a valid range because 1600 seemed to be reasonable as a lower bound
	# and 2400 was just above SuperJ6's max rating
	
# we then went through each user and called their individual API
	# the challenge mentioned that the handle should have been Jason's alt,
	# and that Jason has participated in the majority of contests after July 2019
		#using this knowledge, we checked to see if a handle had any contests in common with Jason ('same')
		#and if it participated in a contest before June/July 2019 ('old')
	#if neither was true, we added it to the list 'valid' and wrote it to a file for cache purposes

#several hours into running we had a list of about 500 valid handles, and after scrolling through these we found the necessary handle
	# LITCTF{MaddyBeltran}
