## WHAT'S THAT
It is a custom oauth2 server mainly for microservices architecture, but could be used to implement a common user authorization as well

## HOW TO USE
This is Java 1.8 maven project, so after indexing and having all dependencies onboard

 - you're free to create your DB and schema (PostgreSQL is used in this project, but could be changed to whatever you want)

 - change properties file to set up things for you (feel free to convert it to .yml also)
   
 - fix stuff in classpath:db/changelog folder files (there are logins and passwords for initial users - now they're dummy)

 - if necessary - create new migration files (Liquibase is rolling here) and include them in db.changelog-master.xml

You're good to go, project should start without any problems.

Depending on what you've got in DB (oauth_client_details) you can do things like:

POST to http://localhost:40001/oauth/token with Authorization Basic base64_login:pass and x-www-form-urlencoded body with

```
 grant_type:password
 username:your_username
 password:your_password
```

and the magic should happen!
