#!/usr/bin/env groovy
def call() {
    bat 'echo "maven test package"'
    bat 'mvn test'
}