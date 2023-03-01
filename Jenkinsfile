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

        stage('Get POM version') {
          steps {
            script {
              def pom = readMavenPom file: 'pom.xml'
              echo "POM version is ${pom.version}"
            }
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
                    def image = docker.build('pkinuk/dev/configuration')
                    image.push()
                  }
                }
              }
        }

    }
}
