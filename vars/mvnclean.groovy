#!/usr/bin/env groovy
def call() {
    bat "cmd /c echo maven clean package"
    bat "cmd /c mvn clean package"
}
