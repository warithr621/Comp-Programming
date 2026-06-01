s = input().strip()
vowel, y, consonant, n, g = 0, 0, 0, 0, 0
for c in s:
	if c in 'AEIOU':
		vowel += 1
	elif c == 'Y':
		y += 1
	elif c == 'N':
		n += 1
	elif c == 'G':
		g += 1
	else:
		consonant += 1

ans = 0
for ng in range(min(n,g) + 1):
	# ng = number of "ng" consonants being used
	base = consonant + (n - ng) + (g - ng) + ng
	for yy in range(y+1):
		# yy = number of y's used as vowels
		syll = min(
			vowel + yy,
			(base + (y - yy)) // 2
		)
		ans = max(ans, 3 * syll + min(2 * syll, ng))
print(ans)