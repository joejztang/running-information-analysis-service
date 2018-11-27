# running-information-analysis-service

this is a backend platform allowing user to operate on running information. 

In this platform, I use mysql5.6 as database solution and spring boot 2 to support business logic.

it basically has following API endpoint:

* `/running`: this is a post method that create information in database
* `/running/{runningId}`: this is a get method that review running information by giving specific running id
* `/purge/{runningId}`: this is a delete method that delete running information in database by giving specific running id
* `/purgeAll`: this is a delete method that delete all information in database
* `/running/order`: this is a get method that retract all running information ordered by warning level

# how to get it run

1. `docker-compose up -d`
2. go to main folder(in my case */running-information-analysis-service*), and `mvn clean install`

now up and run~

# sample data

```json
[
  {
    "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
    "latitude": "38.9093216",
    "longitude": "-77.0036435",
    "runningDistance": "39492",
    "totalRunningTime": "2139.25",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross0",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "07e8db69-99f2-4fe2-b65a-52fbbdf8c32c",
    "latitude": "39.927434",
    "longitude": "-76.635816",
    "runningDistance": "1235",
    "totalRunningTime": "3011.23",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross1",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "2f3c321b-d239-43d6-8fe0-c035ecdff232",
    "latitude": "40.083824",
    "longitude": "-76.098019",
    "runningDistance": "23567",
    "totalRunningTime": "85431.23",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross2",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "28810a26-25e6-4680-8baf-59bb07c4aee0",
    "latitude": "42.957466",
    "longitude": "-76.344201",
    "runningDistance": "11135",
    "totalRunningTime": "98965",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross3",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "fb0b4725-ac25-4812-b425-d43a18c958bb",
    "latitude": "38.5783821",
    "longitude": "-77.3242436",
    "runningDistance": "231",
    "totalRunningTime": "123",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross4",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "35be446c-9ed1-4e3c-a400-ee59bd0b6872",
    "latitude": "42.375786",
    "longitude": "-76.870872",
    "runningDistance": "0",
    "totalRunningTime": "0",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross5",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  },
  {
    "runningId": "15dfe2b9-e097-4899-bcb2-e0e8e72416ad",
    "latitude": "40.2230391039276",
    "longitude": "-76.0626631118454",
    "runningDistance": "0.1",
    "totalRunningTime": "0.1",
    "heartRate": 0,
    "timestamp": "2017-04-01T18:50:35Z",
    "userInfo": {
      "username": "ross6",
      "address": "504 CS Street, Mountain View, CA 88888"
    }
  }
]
```