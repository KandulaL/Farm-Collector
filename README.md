JJFarm Project
•	Configure your database connection details.
•	Test API endpoints using a tool like Postman
•	
You can check the health of the application by running the following command:
http://localhost:8080/actuator/health {"status":"UP"}

# Farm Data API
## Base URL -- http://localhost:8080/jjFarm
Endpoints:
1.	Save a new farm data
POST /createFarm
Description: Saves a new row in DB with the given data.
Request Body:
Code
{
    "farmId": "1",
    "farmerName": "farmer1",
    "cropName": "corn",
    "farmArea": "100",
    "harvestExpected": "500",
    "season": "Spring"
}
2.	Farm data updates with actual harvest
POST /updateFarm
Description: Updates in DB with the actual harvet.
Request Body:
Code
{
    "farmId": "1",
    "farmerName": "farmer1",
    "cropName": "corn",
    "farmArea": "100",
    "harvestActual": "400",
    "season": "Spring"
}

3. Report - Retrieves a list of all farms.
GET /reports
Response:

json
[
    {
    "farmId": "1",
    "farmerName": "farmer1",
    "cropName": "corn",
    "farmArea": "100",
    "harvestExpected": "500",
    "harvestActual": "400",
    "season": "Spring"
    },
    {
    "farmId": "2",
    "farmerName": "farmer2",
    "cropName": "potato",
    "farmArea": "200",
    "harvestExpected": "400",
    "harvestActual": "410",
    "season": "Fall"
    }
]

4. Get a specific report by farm ID.
GET /reports/1
Response:
json
{
    "farmId": "1",
    "farmerName": "farmer1",
    "cropName": "corn",
    "farmArea": "100",
    "harvestExpected": "500",
    "harvestActual": "400",
    "season": "Spring"
}

5. Report by Crop Type- Retrieves a list of all farms for a particular Crop.
          GET /reports/{cropType}

Sample Request: GET /reports/corn
Response:
json
[
    {
    "farmId": "1",
    "farmerName": "farmer1",
    "cropName": "corn",
    "farmArea": "100",
    "harvestExpected": "500",
    "harvestActual": "400",
    "season": "Spring"
    },
    {
    "farmId": "3",
    "farmerName": "farmer2",
    "cropName": "corn",
    "farmArea": "200",
    "harvestExpected": "400",
    "harvestActual": "410",
    "season": "Fall"
    }
]

    

