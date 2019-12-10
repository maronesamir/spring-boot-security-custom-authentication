This is part [part II](https://github.com/maronesamir/spring-boot-security-custom-authentication) of a series of articles on Spring security topic, 
The first part with basic authenticationcan be found here. Instead of using inMemoryAuthentication we will use for the frist time AuthenticationProvider to authenticate the users, afterwards we implement a custom UserDetailsService to load users.

Curl command:
```
curl http://localhost:8080
curl http://localhost:8080/protected
curl http://localhost:8080/protected -u john:secret
curl http://localhost:8080/admin -u john:secret
curl http://localhost:8080/admin -u admin:supersecret
```

More articles can be found here: https://wstutorial.com