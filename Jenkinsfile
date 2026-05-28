pipeline {
    agent any
    tools {
        maven 'Maven-3.9.16'
    }
    stages {
        stage('Checkout'){
            steps {
                checkout scm
            }
        }
        stage('Compile'){
            steps {
                bat '${mvnHome}/bin/mvnw clean compile'
            }
        }
        stage('Test Feature') {
            when { branch pattern: "feature/.*", comparator: "REGEXP"}
            steps{
                bat '${mvnHome}/bin/mvnw test'
            }
        }
    }
}
