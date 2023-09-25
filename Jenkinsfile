@Library('MySharedLibrary') _

pipeline {
    agent any

    environment {
        SONAR_TOKEN = '9f653bddd7a6eb4a9a12ef62f277c1aeb444bae1'
        CHANGELOG_FILE = 'changelog.txt'
        FEATURE_BRANCH = 'feature-branch'
    }

    triggers {
        pollSCM('0/15 * * * * *') // Poll every 15 sec
    }

    stages {
        stage('Cloning code') {
            steps {
                // Disable verbose logging
                  bat 'echo on'
                
                // Checkout the code from your Git repository
                checkout scmGit(branches: [
                    [name: '*/feature-branch/*']
                ], extensions: [], userRemoteConfigs: [
                    [credentialsId: 'eff71e39-4211-419e-9697-07e14f18835d', url: 'https://github.com/RishabhAlchetti/springboot-api.git']
                ])
                  bat 'echo off'
            }
        }

        stage('Remove Previous Container') {
            steps {
                script {
                    try {
                        bat 'docker rm -f container'
                    } catch (Exception e) {
                        // Do nothing if there is an exception
                    }
                }
            }
        }
       
        stage('Maven clean and install') {
            steps {
                bat 'mvn clean install'
            }
        }
 
      //   stage('Talisman Scan') {
    //         steps {
    //             script {
    //                 // Run Talisman to scan for sensitive data
    //                 bat 'talisman --scan'
    //             }
    //         }
    //     }
    
      stage('Archive SBOM Reports'){
            steps {
                      archiveArtifacts artifacts: '**/bom.*', allowEmptyArchive: true
                }
        }
        
        stage('Generate jacoco Report'){
            steps{
                    bat "cmd /c mvn jacoco:report"
                  }
                }

          stage('SonarQube Analysis'){
            steps {
                script {
                      sonaranalysis()
                }
            }              
        }
        

        stage('Build and push Docker Image') {
            steps {
                bat 'docker build -t rishabhalchetti/demo-repo-123 .'
                withCredentials([string(credentialsId: 'ac7d3845-8435-4e00-9c74-86bd081e060f', variable: 'dockerPassword')]) {
                    bat "docker login -u rishabhalchetti -p %dockerPassword%"
                }
                bat 'docker tag rishabhalchetti/demo-repo-123 rishabhalchetti/demo-repo-123:%BUILD_NUMBER%'
                bat 'docker push rishabhalchetti/demo-repo-123:%BUILD_NUMBER%'
            }
        }
        
        stage('Docker deployment') {
            steps {
                bat 'docker run -d -p 8080:8080 --name container1 rishabhalchetti/demo-repo-123:latest'
            }
        }
    }
}
