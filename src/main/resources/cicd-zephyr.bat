:: !/bin/sh
:: title         :cicd-zephyr.bat
:: description   :Ths script will publish the automation results to Zephyr for Jira Cloud
:: author        : Angelica Forero
:: date          : 08252022
:: version       :1.0


:: ==========CONFIG==========
set "$zephyrBaseUrl=https://prod-api.zephyr4jiracloud.com/connect"
set "$accessKey="NWE1YWNiNWYtNGMzNy0zYWRlLTllZGUtMzBhMzNiODhmMmIzIDYyMmE1ZmY4YTY4N2M1MDA2YTYyZmZhYSBVU0VSX0RFRkFVTFRfTkFNRQ"
set "$secretKey="HH2Or8nMOkUmIXZaow4T1RruuGW_4k7x07MBHlTHhOs"
set "$accountId="557058:622a5ff8a687c5006a62ffaa"

:: =========================================
::  Create a JSON Web Token
:: =========================================
echo "Generating a JSON Web Token ..."
for /F "tokens=*" %%i in (' curl -s -X POST -H "Content-Type: application/json" --data "{ \"accessKey\":\"%$accessKey%\", \"secretKey\":\"%$secretKey%\",\"accountId\":\"%$accountId%\",\"zephyrBaseUrl\": \"%$zephyrBaseUrl%\",\"expirationTime\":360000}" "https://prod-vortexapi.zephyr4jiracloud.com/api/v1/jwt/generate" ')  do set jwtgenerated=%%i
set "$finaljwt=%jwtgenerated%"
echo %$finaljwt%

:: =========================================
::  Job information
:: =========================================

:: Task info
set "$taskName="CICD Test"
set "$taskDescription="Generate reports the test integrated with CICD"
set "$automationFramework="TestNG"
set "$projectKey="BDD"
set "$versionName="Unscheduled"

:: Cycle info
set "$cycleName="CICD Automation"
set "$createNewCycle="true"
set "$appendDateTimeInCycleName="false"

:: Folder info
set "$folderName="Regression test"
set "$createNewFolder="true"
set "$appendDateTimeInFolderName="true"
set "$assigneeUser="557058:622a5ff8a687c5006a62ffaa"

:: Fully-qualitified name of the test result file
set "$resultPath=@\"target/cucumber/events"

:: =========================================
::  Create an automation task, run it, send test results to Zephyr.
:: =========================================
echo "Creating and running an automation task ..."
curl -v -X POST  https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/saveAndExecute  -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -H "accessKey: %$accessKey%" -H "jwt: %$finaljwt%" -F "jobName=%$taskName%" -F "jobDescription=%$taskDescription%" -F "automationFramework=%$automationFramework%" -F "projectKey=%$projectKey%" -F "versionName=%$versionName%" -F "cycleName=%$cycleName%" -F "createNewCycle=%$createNewCycle%" -F "appendDateTimeInCycleName=%$appendDateTimeInCycleName%" -F "folderName=%$folderName%" -F "createNewFolder=%$createNewFolder%" -F "appendDateTimeInFolderName=%$appendDateTimeInFolderName%" -F "assigneeUser=%$assigneeUser%" -F "file=%$resultPath%"


:: =========================================
::  Update the properties of automation task and  run it, send test results to Zephyr.
::
::  The code below uses "task properties" values defined in lines 38-56.
::  Update them to change task properties.
::
::  To run the code below, first comment out the lines 62-63 above that create your automation task,
::  and then uncomment in the lines below.
:: =========================================

:: Id of your automation task. You get it after the task is created.
:: set "$taskId=XXXXXXXXXXXXXXXXXXXX42E96E8863BF7EEE44BDB95FF763DA3E9C3BC4776886"

:: echo "Updating and running the automation task"
:: curl -v -X PUT  https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/updateAndExecute  -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -H "accessKey: %$accessKey%" -H "jwt: %$finaljwt%"  -F "jobId=%$taskId%" -F "jobName=%$taskName%" -F "jobDescription=%$taskDescription%" -F "automationFramework=%$automationFramework%" -F "versionName=%$versionName%" -F "cycleName=%$cycleName%" -F "createNewCycle=%$createNewCycle%" -F "appendDateTimeInCycleName=%$appendDateTimeInCycleName%" -F "folderName=%$folderName%" -F "createNewFolder=%$createNewFolder%" -F "appendDateTimeInFolderName=%$appendDateTimeInFolderName%" -F "assigneeUser=%$assigneeUser%" -F "file=%$resultPath%"
