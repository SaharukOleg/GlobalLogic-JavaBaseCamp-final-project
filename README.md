# Game of Basecamp

GlobalLogic JavaBaseCamp final project.


### Prerequisites

What things do you need to install

```
Java SDK 8
Gradle
```

### Installation

- Clone Git repository
```
https://github.com/SaharukOleg/GlobalLogic-JavaBaseCamp-final-project.git
```


## Examples
1. before running the main method ad one or more Character to the database, in postman use localhost:8080/outside/{anyID}
2. if you want try my main logic please use localhost:8080/character/randomFellow/{idFromDB} // this method get add analize 
character from DB
3. if y want use Pagination use  @GetMapping "/characters" // if after url use ?page=0&size=2 ,  you can see first two characters ...
4. get by name @GetMapping value = "/character also use Pagination  ?name=nameCharacterFromDB
3. name entity is Characterrr because 'Character' it is key word in mySql DB  before connecting h2 i worked with mySql

