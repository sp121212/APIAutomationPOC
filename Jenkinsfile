pipeline {
   agent any
   tools {
      maven 'maven'
   }
   environment{
       BUILD_NO = "${BUILD_NUMBER}"
       }

   

   stages {
      stage('Developer Build') {
         steps {
            git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }
         post {
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
            }
         }
      }
   
      stage("Deploy to QA") {
         steps {
            echo("deploy to qa !!!!!!!!!!!!!!!! 4")
         }
      }
      
      stage('Run Tests with - Docker Images') {
         steps {  	
           	bat "docker run  -it santanu1212/test13:latest"
           	// Even if the tests fail copy the report 
           	bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/SanityTest.xml"
           	bat "docker start apitest_${BUILD_NUMBER}"
           	bat "docker cp  apitest_${BUILD_NUMBER}: /app/reports/APITestExecutionReport.html ${WORKSPACE}/reports"
           	bat "docker rm -f apitest_${BUILD_NUMBER}"
           	
           }
         }
      
      
      stage('Publish Extent Report QA') {
         steps {
            publishHTML([allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: 'APITestExecutionReport.html',
            reportName: 'API HTML Regression Extent Report',
            reportTitles: ''])
         }
      }
    }
 }   
  