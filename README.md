# Reading app

Based on weekly new words.  When you enter a block of text, the new words will be high-lighted.  

This is to help the reader know which words he / she should know.

## Prerequisites
* Java Runtime Engine (JRE) 8 & above
* Gradle 5.2.1
* Spring Boot 2 and Spring framework 5

## Running the app

```
./gradlew bootrun
```
Access the app
```
http://localhost:8028/app/read
```

**Where to configure new words?**  
For now, in HighLightService constructor.  Later will create config page.

### ToDo
* Mark words when punctuation present (eg , . ! ? etc)
* Add clear button
* Add actuator for health checks
