# Internetofthings
egen solutions java challenge project

- Actual logic start from  emulatorcontroller.java which exposes the requested services.
postman rest ui was used to test it.
dependencies include 
1)easyrules
2)web
3)mongo db
4)morphis
etc.

- Easy rule comments include "you are over weight" and "you are underweight"

- MongoDB is made persistent across transactions.

- DTO and model classes are used to carry data across.

- Service communicates between controller and morphis.



 Since there are many services to be exposed below is the url at which the create metric api listens to the input and stored in mongodb
-----------------------------------------------------------------------------------------------------
java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/api/emulator/createMetric sensor-emulator-0.0.1-SNAPSHOT.jar

continuous input from from above resource is stored accordingly with proper validations.

Below are the list of service endpoints and request/responses
----------------------------------------------------------------------

POST

http://localhost:8080/api/emulator/readAllMetricsInTimeRange

Request:
{
  "startTimeStamp": "1470828953131", 
  "endTimeStamp": "9470828973645"
}

---------------------------------------------------------------------------------
POST

http://localhost:8080/api/emulator/readAllAlertsInTimeRange

Request:
{
  "startTimeStamp": "1470828953131", 
  "endTimeStamp": "9470828973645"
}
----------------------------------------------------------------------------------
POST

http://localhost:8080/api/emulator/createMetric

Request:
{
  "timeStamp": "9958062848734", 
  "value": "153"
}
-------------------------------------------------------------------------------
GET

http://localhost:8080/api/emulator/readAllAlerts

response:
[
  {
    "timeStamp": "1470834119643",
    "value": "166",
    "alertMessage": "you are over weight"
  }....
-----------------------------------------------------------------------------
GET

http://localhost:8080/api/emulator/readAllMetrics


response:

[
  {
    "timeStamp": "1470830111529",
    "value": "150"
  },....
