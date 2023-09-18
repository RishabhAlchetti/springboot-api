#!/usr/bin/env groovy
def call() {
    bat 'echo "maven install"'
    bat 'mvn install'
}


