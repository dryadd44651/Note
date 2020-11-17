# why use different salt every time
> if don't use salt->crack by dictionary attack (frequency of words)

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
