def call() {
    sh 'echo "sonar analysis"'
    sh 'mvn verify sonar:sonar -Dsonar.organization=expleo123 -Dsonar.projectKey=expleo123 -Pcoverage'
}





