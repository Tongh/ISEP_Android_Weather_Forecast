# ISEP_Android_Weather_Forecast
## Group 4
WANG Wenxiao<br>
JIANG Meng<br>
XU Silong<br>

---

## Presentation about our application
A world -class application displays the weather information regarding the city or area that the user located or the user chooses. Include detailed information such as temperature, pressure, humidity, wind speed, cloudiness etc.<br>
Data visualization is also available in our application: line charts by default, bar graphs and other kinds of charts are provided to the user.

## Features

### Feature that must be implemented
#### Background page switch regarding the weather
-Background page will be different regarding the current weather of the city that user searched.
#### Hourly forecast 24 hours
-Display hourly weather information within 24 hours with the icon corresponding to the temperature in a row way.<br>
-Row sliders component
#### Daily forecast 7 days
-Display daily weather information within a week in a column way.
-Column sliders component
#### Search système
-Navigation drawer component, dialog component<br>
-User can search city information by entering a city name, we will use regular expressions to match the result, if the city name that user entered is correct or exists, the result will be displayed, otherwise a notice dialog will be shown to notice “wrong city name”.
#### Cache storage for the city that user has searched before
-City name that user searched before will be stored in our off-line database. We check first whether this city name has been stored in our database, if yes, we display directly the result that our database stored instead of invoking the web api, if not we will fetch the data using web api.


### Features that would be nice to have
#### Data visualization
-Echarts<br>
-Show hourly weather information within 24h using charts, like line charts and bar charts.


### Non-primordial features
#### List city name that user has searched before
-A column list shows the city that the user has searched before. User can check the city by touching the city name rather than searching.

# Data Source & Data Structure
## Current Weather
API: https://api.openweathermap.org/data/2.5/weather?lat=48.8534&lon=2.3486&appid=4b1fe12967fbc1e9b76903af4985d45f <br>
JsonResponse:
```json
{
    "coord":{
        "lon":2.3486,
        "lat":48.8534
    },
    "weather":[
        {
            "id":701,
            "main":"Mist",
            "description":"mist",
            "icon":"50d"
        }
    ],
    "base":"stations",
    "main":{
        "temp":281.95,
        "feels_like":281.95,
        "temp_min":280.92,
        "temp_max":282.67,
        "pressure":1023,
        "humidity":97
    },
    "visibility":4000,
    "wind":{
        "speed":0.45,
        "deg":270,
        "gust":0.89
    },
    "clouds":{
        "all":90
    },
    "dt":1637136758,
    "sys":{
        "type":2,
        "id":2041230,
        "country":"FR",
        "sunrise":1637132576,
        "sunset":1637165311
    },
    "timezone":3600,
    "id":2968815,
    "name":"Paris",
    "cod":200
}
```

## Forecast
API: https://api.openweathermap.org/data/2.5/onecall?lat=48.824272&lon=2.27326&appid=4b1fe12967fbc1e9b76903af4985d45f <br>
JsonResponse:
```json
{
    "lat":48.8243,
    "lon":2.2733,
    "timezone":"Europe/Paris",
    "timezone_offset":3600,
    "current":{
        "dt":1637141832,
        "sunrise":1637132588,
        "sunset":1637165335,
        "temp":282.82,
        "feels_like":280.94,
        "pressure":1024,
        "humidity":98,
        "dew_point":282.52,
        "uvi":0.66,
        "clouds":90,
        "visibility":3100,
        "wind_speed":3.6,
        "wind_deg":290,
        "weather":[
            {
                "id":701,
                "main":"Mist",
                "description":"mist",
                "icon":"50d"
            }
        ]
    },
    "minutely":[
        {
            "dt":1637141880,
            "precipitation":0
        }, etc.
    "hourly":[
        {
            "dt":1637139600,
            "temp":282.8,
            "feels_like":281.57,
            "pressure":1024,
            "humidity":96,
            "dew_point":282.19,
            "uvi":0.29,
            "clouds":92,
            "visibility":10000,
            "wind_speed":2.48,
            "wind_deg":273,
            "wind_gust":7.93,
            "weather":[
                {
                    "id":804,
                    "main":"Clouds",
                    "description":"overcast clouds",
                    "icon":"04d"
                }
            ],
            "pop":0
        }, etc.
    "daily":[
        {
            "dt":1637146800,
            "sunrise":1637132588,
            "sunset":1637165335,
            "moonrise":1637163000,
            "moonset":1637124480,
            "moon_phase":0.44,
            "temp":{
                "day":283.25,
                "min":280.81,
                "max":286.12,
                "night":281.67,
                "eve":284.09,
                "morn":281.84
            },
            "feels_like":{
                "day":282.77,
                "night":280.95,
                "eve":283.33,
                "morn":281.23
            },
            "pressure":1024,
            "humidity":94,
            "dew_point":282.33,
            "wind_speed":2.97,
            "wind_deg":306,
            "wind_gust":7.93,
            "weather":[
                {
                    "id":804,
                    "main":"Clouds",
                    "description":"overcast clouds",
                    "icon":"04d"
                }
            ],
            "clouds":91,
            "pop":0.11,
            "uvi":1.04
        }, etc.
    ]
}

```

## City name to Lat long
API: https://maps.googleapis.com/maps/api/geocode/json?address=issylesmoulineux&key=AIzaSyAYE39CrIN_0fcSmDERaroK_lXrE8VwWMk <br>
JsonResponse:
```json
{
   "results" : [
      {
         "address_components" : [
            {
               "long_name" : "伊西莱穆利诺",
               "short_name" : "伊西莱穆利诺",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "上塞纳",
               "short_name" : "上塞纳",
               "types" : [ "administrative_area_level_2", "political" ]
            },
            {
               "long_name" : "法兰西堡",
               "short_name" : "IDF",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "法国",
               "short_name" : "FR",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "92130",
               "short_name" : "92130",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "法国伊西莱穆利诺邮政编码: 92130",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : 48.8345924,
                  "lng" : 2.2894075
               },
               "southwest" : {
                  "lat" : 48.8133083,
                  "lng" : 2.2361072
               }
            },
            "location" : {
               "lat" : 48.8245306,
               "lng" : 2.2743419
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : 48.8345924,
                  "lng" : 2.2894075
               },
               "southwest" : {
                  "lat" : 48.8133083,
                  "lng" : 2.2361072
               }
            }
         },
         "partial_match" : true,
         "place_id" : "ChIJxy7Ltot65kcRoSduGnfQJos",
         "types" : [ "locality", "political" ]
      }
   ],
   "status" : "OK"
}
```


