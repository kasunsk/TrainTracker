Train-tracker Documentation
===========================

Abstract
========
This is a simple mobile application to track a train. The train send his location details using GPS coordinates to the server. Then the server get those details and process data and call Google location web service and get the extract location of the train. Then send all those data to database. Server calculate the train speed by considering current location and privies location. Save all data in mysql database. When a customer ask for spacial train the server send related data to the customer using Spring MVC web service.

This implementation only supply Java code as clients and anyone can change it to use in mobile application (Android) easily.

Introduction
============
Spring MVC , java , Gradle , Mysql , JDBC , Rest , JSON were used to implement.
This project is a skeleton code. Mobile applications have not implemented. Simple Java code has used instead of that. In this project trains locations are randomly generate for testing. Mobile application developer must develop GPS recognize and sending.


Project Objective 
=================
Develop a mobile application to Track a train.
Application will track Train Location and Speed.

Set Up Project
==============
Copy the Project folder into Computer.
Go to that directory(MainServer folder or Client folder or TrainClientDivice folder) in terminal
Then type 
             $ gradle clean eclipse
Then
Open Eclipse → File → import → Existing Project in to workspace → Select the root directory → import
Do same things to three projects.

Build the project
=================
Go to project directory in terminal

type $ gradle clean build
Do same things to all projects.
Then you can find a build folder in all project. 

Deploy Project
==============
Before that you have to set up mysql database (TrainTracker)
Run in mysql 	
                CREATE DATABASE TrainTracker; .
		SELECT  TrainTracker;
		CREATE TABLE  abc  (Num INT(2) , Lon VARCHAR(80) , Lat VATCHAR(80) , Location VARCHAR(40) , Speed  VARCHAR(5));

Then
Go to MainServer project go in to build the lib folder and copy MainServer.war file 
Then go to Tomcat7 folder where you have installed it. Past the war file in webapp folder.
Then go come back to Tomcat folder and go to bin folder.

Then type       
                $ ./catalina.sh run

Now your MainServerProject is deploying in localhost.

Open a new terminal and
Then go to ClientTrainDevice project → build → lib in terminal and 

type 
                $ java -jar ClientTrainDevice.jar

Then TrainClientDevice will be run.

Then go to Client project → build →lib folder in terminal.

Type 
                $ java -jar Client 

Now you can see the location and speed of the train in current time. You can run it again and again and check the location of virtual train.
