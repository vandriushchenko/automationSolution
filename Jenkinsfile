pipeline {
    agent { label 'selenium' }
        tools {
            maven 'maven 3.5.4'
            jdk 'jdk 11.0.1'
        }

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