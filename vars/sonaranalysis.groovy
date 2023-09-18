def call() {
    bat 'echo "sonar analysis"'
    bat 'mvn verify sonar:sonar -Dsonar.organization=expleo123 -Dsonar.projectKey=expleo123 -Pcoverage'
}





