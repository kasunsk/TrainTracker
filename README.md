		Train-tracker Documentation

Abstract

This is a simple mobile application to track a train. The train send his location details using GPS coordinates to the server. Then the server get those details and process data and call Google location web service and get the extract location of the train. Then send all those data to database. Server calculate the train speed by considering current location and privies location. Save all data in mysql database. When a customer ask for spacial train the server send related data to the customer using Spring MVC web service.

This implementation only supply Java code as clients and anyone can change it to use in mobile application (Android) easily.

Introduction

Spring MVC , java , Gradle , Mysql , JDBC , Rest , JSON were used to implement.
This project is a skeleton code. Mobile applications have not implemented. Simple Java code has used instead of that. In this project trains locations are randomly generate for testing. Mobile application developer must develop GPS recognize and sending.
