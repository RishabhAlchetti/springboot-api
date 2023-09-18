#!/usr/bin/env groovy
def call() {
    bat 'echo "maven clean package"'
    bat 'mvn clean package'
}
