#!/usr/bin/env groovy
def call() {
    bat "cmd /c echo maven test package"
    bat "cmd /c mvn test"
}
