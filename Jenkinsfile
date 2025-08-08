pipeline {
  agent any

  tools {
    maven 'Maven 3.9.10'   // Must match Jenkins Maven tool name
    jdk 'Java 21'          // Must match Jenkins JDK tool name
  }

  environment {
    BROWSER = 'chrome'
    HEADLESS = 'true'
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/m-amaann/automation-selenium-framework.git'
      }
    }

    stage('Verify Versions') {
      steps {
        sh 'mvn -v'
        sh 'java -version'
      }
    }

    stage('Build & Run Tests') {
      steps {
        sh 'mvn clean test -Dbrowser=${BROWSER} -Dheadless=${HEADLESS}'
      }
    }

    stage('Publish Extent Report') {
      steps {
        publishHTML([
          reportDir: 'reports',             // This should match the Extent report output folder
          reportFiles: 'index.html',        // The main report file
          reportName: 'Test Report',
          keepAll: true,
          alwaysLinkToLastBuild: true
        ])
      }
    }
  }

  post {
    always {
      echo 'Pipeline execution completed.'
    }
  }
}