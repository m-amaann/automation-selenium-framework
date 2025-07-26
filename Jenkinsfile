pipeline {
  agent any

  environment {
    // Jenkins credentials IDs for Docker Hub and SonarQube token
    DOCKER_USERNAME = credentials('dockerhub-username')
    DOCKER_PASSWORD = credentials('dockerhub-password')
    SONAR_TOKEN = credentials('sonarqube-token')

    ALLURE_RESULTS = 'target/allure-results'
    ALLURE_REPORT = 'target/allure-report'

    IMAGE_NAME = "yourdockerhubusername/selenium-framework"
    IMAGE_TAG = "${env.BUILD_NUMBER}"
  }
  stages {
    stage('Checkout Code') {
      steps {
        git url: 'https://github.com/m-amaann/automation-selenium-framework.git', branch: 'main'
      }
    }
    stage('Clean Workspace & Reports') {
      steps {
        sh 'mvn clean'
        sh "rm -rf ${ALLURE_RESULTS} ${ALLURE_REPORT}"
      }
    }
    stage('Run Tests') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Generate Allure Report') {
      steps {
        sh "allure generate ${ALLURE_RESULTS} --clean -o ${ALLURE_REPORT}"
      }
    }
    stage('Archive & Publish Report') {
      steps {
        archiveArtifacts artifacts: "${ALLURE_REPORT}/**", fingerprint: true
        allure includeProperties: false, results: [[path: "${ALLURE_RESULTS}"]]
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}



