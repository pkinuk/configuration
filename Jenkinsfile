pipeline {
    agent any

    tools {
        jdk 'Java17'
        maven 'maven-3.9.0'
    }

    stages {
        stage('Check version') {
            steps {
                sh 'mvn -version'
            }
        }
        stage('Checkout') {
            steps {
                git url: 'https://github.com/pkinuk/configuration.git'
            }
        }


        stage('Build') {
            steps {

                // Run the build and capture the exit code
                script {
                    def buildExitCode = sh(script: './mvnw clean install', returnStatus: true)
                    if (buildExitCode != 0) {
                        error('Build failed!')
                    }
                }
            }
        }

        stage('Push docker hub') {
              steps {
                script {
                  docker.withRegistry('https://registry.hub.docker.com', 'DockerHubPkinuk') {
                    sh 'docker push dev/configuration:1.0.0-SNAPSHOT'
                  }
                }
              }
        }

    }
}
