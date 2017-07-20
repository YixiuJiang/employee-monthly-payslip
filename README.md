MYOB code test
======
This is a simple spring boot app to calculate employee monthly payslip. Currently it only support CSV input and output.

##Prerequirement
1. JAVA 8
2. Gradle 3.5
3. Maven

##Build

Windows:

`gradlew.bat build`

Linux/Mac:

`./gradlew build`


## Run
1. Simply run `./gradlew bootRun`
4. By default it will pickup csv here `src/main/resource/input.csv` and write output CSV into the folder where you run this app.

## Test
1. Simply run `./gradlew test` 
2. To check test coverage, run `./gradlew test jacocoTestReport`

##Configuration
1. Tax rate and input CSV file is configurable here: `src/main/resource/application.yml
2. You can specify your input csv and out put csv by using `./gradlew bootRun -DinputCSVFile=/youroutputcsvfilepath -DoutputCSVFile=/youroutputcsvfilepath`

##Important information!
To make it simple, currently only support payslip for one calendar month, which mean, will have the same output regardless payment period. Sorry for being lazy here :)


