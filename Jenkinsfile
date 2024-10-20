pipeline {
   agent any
   tools {
      maven 'maven'
   }
   stages {
      stage('Build') {
         steps {
            git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            sh "mvn -Dmaven.test.failure.ignore=true clean package"
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
            echo("deploy to qa")
         }
      }
      
      stage('Regression API Automation Tests') {
         steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
               git 'https://github.com/sp121212/APIAutomationPOC.git'
               sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/SanityTest.xml"
            }
         }
      }
      stage('Publish Allure Reports') {
         steps {
            script {
               allure([
               includeProperties: false,
               jdk: '',
               properties: [],
               reportBuildPolicy: 'ALWAYS',
               results: [[path: '/allure-results']]
               ])
            }
         }
      }
      stage('Publish Extent Report') {
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
      
      stage("Deploy to Stage") {
         steps {
            echo("deploy to stage")
         }
      }
      
      stage('Regression API Automation Tests') {
         steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
               git 'https://github.com/sp121212/APIAutomationPOC.git'
               sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/Amadeus-API.xml"
            }
         }
      }
      stage('Publish Extent Report') {
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
      stage("Deploy to Prod") {
         steps {
            echo("deploy to prod")
         }
      }
   }
}