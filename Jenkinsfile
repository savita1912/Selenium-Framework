pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Build') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'mvn test'
            }
        }

    }

    post {

        always {
            archiveArtifacts artifacts: 'target/**/*.html', allowEmptyArchive: true

            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}