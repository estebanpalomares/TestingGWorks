######################################################################
#!/bin/sh
#title         :cicd-zephyr.sh
#description   :Ths script will publish the automation results to Zephyr for Jira Cloud
#author        : Angelica Forero
#date          : 08252022
#version       :1.0
######################################################################

######################################################################
#  CONFIG
######################################################################
zephyrBaseUrl="https://prod-api.zephyr4jiracloud.com/connect"
accessKey="NWE1YWNiNWYtNGMzNy0zYWRlLTllZGUtMzBhMzNiODhmMmIzIDYyMmE1ZmY4YTY4N2M1MDA2YTYyZmZhYSBVU0VSX0RFRkFVTFRfTkFNRQ"
secretKey="HH2Or8nMOkUmIXZaow4T1RruuGW_4k7x07MBHlTHhOs"
accountId="5557058:622a5ff8a687c5006a62ffaa"

#######################################################################
#   Create a JSON Web Token
#######################################################################
echo "Generating a JSOM Web Token ... \n"
curl -o headers -s -d '{  "accessKey": "'"$accessKey"'"  , "secretKey": "'"$secretKey"'" ,"accountId": "'"$accountId"'","zephyrBaseUrl": "'"$zephyrBaseUrl"'","expirationTime":360000}' -H "Content-Type: application/json" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/jwt/generate
jwt="$(cat  headers | head -n 1)"
echo "The generated token: \n"
echo $jwt

#######################################################################
#  Job information
#######################################################################

# Task info
taskName="CICD Automation Test"
taskDescription="Generate reports the test integrated with CICD"
automationFramework="TestNG"
projectKey="BDD"
versionName="Unscheduled"

# Cycle info
cycleName="CICD Automation"
createNewCycle="true"
appendDateTimeInCycleName="false"

# Folder info
folderName="RegressionTests"
createNewFolder="true"
appendDateTimeInFolderName="true"
assigneeUser="557058:622a5ff8a687c5006a62ffaa"

# Name of the test result file
resultPath="@//target/surefire-reports/testng-results.xml"

#######################################################################
#  Create an automation task, run it, send test results to Zephyr.
#######################################################################
echo "Creating and running an automation task ..."
curl -o headers -s -v -H "accessKey: $accessKey" -H "jwt: $jwt" -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -F "jobName=$taskName" -F "jobDescription=$taskDescription" -F "automationFramework=$automationFramework" -F "projectKey=$projectKey" -F "versionName=$versionName" -F "cycleName=$cycleName" -F "createNewCycle=$createNewCycle" -F "appendDateTimeInCycleName=$appendDateTimeInCycleName" -F "folderName=$folderName" -F "createNewFolder=$createNewFolder" -F "appendDateTimeInFolderName=$appendDateTimeInFolderName" -F "assigneeUser=$assigneeUser" -F "file=$resultPath" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/saveAndExecute
result="$(cat  headers | head -n 1)"
echo "Test results: \n"
echo $result
# END of the "Create task" code

#######################################################################
#  Update the properties of automation task and  run it, send test results to Zephyr.
#
#  The code below uses "task properties" values defined in lines 40-58.
#  Update them to change task properties.
#
#  To run the code below, first comment out the code lines 64-68 that create your automation task,
#  and then uncomment in the lines below.
#######################################################################

# Id of your automation task. You get it after the task is created.
# taskId="XXXXXXXXXXXXXXXXXXXX42E96E8863BF7EEE44BDB95FF763DA3E9C3BC4776886"

#echo "Update and run the automation task... "

#curl -o headers -s -v -H "accessKey: $accessKey" -H "jwt: $jwt" -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -F "jobId=$taskId" -F "jobName=$taskName" -F "jobDescription=$taskDescription" -F "automationFramework=$automationFramework" -F "versionName=$versionName" -F "cycleName=$cycleName" -F "createNewCycle=$createNewCycle" -F "appendDateTimeInCycleName=$appendDateTimeInCycleName" -F "folderName=$folderName" -F "createNewFolder=$createNewFolder" -F "appendDateTimeInFolderName=$appendDateTimeInFolderName" -F "assigneeUser=$assigneeUser" -F "file=$resultPath" -XPUT https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/updateAndExecute

#result="$(cat  headers | head -n 1)"
#echo $result

# END of the "Update task" code
