pipeline {
    agent any

    stages {
      stage('Integration Tests') {
        steps {
          container('maven') {
            sh 'mvn clean test'
          }
        }
        post {
          always {
            script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
              ])
            }
          }
        }
      }
    }
}