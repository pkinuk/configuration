pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'jdk17'
    }

    stages {
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
    }
}
