def call() {
    sh 'echo "maven clean package"'
    sh 'mvn clean package'
}
