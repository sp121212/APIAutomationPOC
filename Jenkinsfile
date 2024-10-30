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
            echo("deploy to qa !!!!!!!!!!!!!!!!")
         }
      }
      
      stage('Run Tests with - Docker Images') {
         steps {
           script{
           def exitCode = sh(script: "docker run --name apitest${BUILD_NO} -e MAVEN_OPTS='-Dsurefire.suiteXmlFiles=/src/test/resources/testrunners/SanityTest.xml' santanu1212/apitests:latest", returnStatus: true )
           	if(exitCode != 0){
           		currentBuild.result = 'FAILURE' //Mark your build as failed if test fail
           	}
           	// Even if the tests fail copy the report 
           	sh "docker start apitesting${BUILD_NUMBER}"
           	sh "docker cp  apitesting${BUILD_NUMBER}: /app/reports/APITestExecutionReport.html ${WORKSPACE}/reports"
           	sh  "docker rm -f apitesting${BUILD_NUMBER}"
           	
           }
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