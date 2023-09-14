#!/usr/bin/env groovy
def call() {
    bat "cmd /c echo sonar analysis"
    bat "cmd /c mvn verify sonar:sonar -Dsonar.organization=expleo123 -Dsonar.projectKey=expleo123  -Pcoverage"
}





