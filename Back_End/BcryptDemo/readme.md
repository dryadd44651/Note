# why use different salt every time
> if don't use salt->will be cracked by dictionary attack (frequency of words)
>1. every same password will have same hash code
>2. check the password frequency and hash code frequency
```
Here are the top password from 2019:

1. 123456
2. 123456789
3. qwerty
4. password
5. 1234567
6. 12345678
7. 12345
8. iloveyou
9. 111111
10. 123123
```
### salt save with hash
ex:
```
password: monkey
salt: $2b$12$AS7xPPLNwnPIbsxHYrb3ae
hash code: $2b$12$AS7xPPLNwnPIbsxHYrb3aeQ8pU6/awlz3XReKoFfCxgOdV1FyCZTK

hash function is a one way funcntion
hash(password,salt) => hash code
hash code can't get password

when log in with password 'monkey'
get salt and hash code from DB
hash password again with salt
hash(password,salt) => new hash code
compare(new hash code, hash code from DB)
```
