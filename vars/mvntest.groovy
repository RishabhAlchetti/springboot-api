def call() {
    sh 'echo "maven test package"'
    sh 'mvn test'
}
