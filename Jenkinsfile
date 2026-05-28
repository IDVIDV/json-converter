pipeline {
    agent any
    stages {
        stage('Checkout'){
            steps {
                checkout scm
            }
        }
        stage('Compile'){
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test Feature') {
            when { branch pattern: "feature*", comparator: "REGEXP"}
            steps{
                bat 'mvn test'
            }
        }
    }
}
