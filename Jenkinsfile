pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/pkinuk/configuration.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean install'
            }
        }
    }
}
