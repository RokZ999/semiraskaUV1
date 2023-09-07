# Seminar Paper for UVP1
![image](https://user-images.githubusercontent.com/71169333/164452151-1be739a8-f590-4c0c-8263-4d1fc9b4080d.png)

## Overview

Program for a Travel Agency, developed in Java ☕.

### Functionalities

- **User Interface**: Allows user registration and login as either a regular user or admin.
- **Regular User**: Can search and book vacations.
- **Admin**: Has access to all regular user functionalities, plus additional admin functionalities.

## Installation
1. **Clone the Repository**:  Or manually download all files into a folder of your choice.
2. double click on program.bat, This will start program or

## Code Compilation and JAR File Creation

- **Automatic**:  UPDATE-PROGRAM.bat

**Manual**:  

```
javac *.java
jar cvfm TuristicnaAgencijaCLI.jar manifest.txt *.class
java -jar TuristicnaAgencijaCLI.jar
```
## Known Issues
- Upon logging out or terminating the program, an error may occur due to antivirus software that blocks JVM from writing to the `pocitnice.txt` and `uporabniki.txt` files.

