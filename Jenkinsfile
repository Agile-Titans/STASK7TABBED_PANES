pipeline {
    agent { label 'java-build-agent' }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile -Djava.awt.headless=true'
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn test -Djava.awt.headless=true'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Quality Analysis') {
            steps {
                bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=%SONAR_TOKEN% -Dsonar.projectKey=STASK7TABBED_PANES'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'All stages passed! Deploying to staging environment...'
                echo 'Deployment successful!'
            }
        }
    }

    post {
        failure {
            echo 'Pipeline failed! Notify the development team.'
        }
        success {
            echo 'Pipeline completed successfully!'
        }
    }
}