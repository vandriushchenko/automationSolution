pipeline {
    agent any

    stages {
      stage('Integration Tests') {
        steps {
          script {
                              currentBuild.displayName = "${params.suite}-${params.env}-#${env.BUILD_NUMBER}"
                              echo "Test Run for ${params.suite} at env: ${params.env}"

                              sh "mvn clean test"


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