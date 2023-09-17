def call() {
    sh 'echo "maven install"'
    sh 'mvn install'
}
