#!/usr/bin/env groovy
def call() {
    bat "cmd /c echo maven install"
    bat "cmd /c mvn install"
}


