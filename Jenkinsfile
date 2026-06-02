pipeline {
    agent any
    tools {
        maven 'maven-3.9.16'
    }
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
            when { expression {env.GIT_BRANCH =~ '/(feature)/'}}
            steps{
                bat 'mvn test'
            }
        }
        stage("Checkstyle Develop") {
            when { expression {env.GIT_BRANCH = 'develop'}}
            steps{
                bat 'mvn checkstyle:check'
            }
        }
        stage("Test Coverage") {
            steps{
                bat 'mvn verify'
            }
            post {
                always {
                    archiveArtifacts "agg/target/site/**"
                }
            }
        }
        stage("Install"){
            steps{
                bat 'mvn install'
            }
        }
        stage("Quality Gate"){
            steps{
                script{
                    def file = readFile('agg/target/site/jacoco-aggregate/index.html')
                    def regexMatch = file =~ "<td class=\"ctr2\">(\\d+)%</td>"
                    def coverage = regexMatch[0][1] as int
                    if (coverage < 60) {
                        error "Quality Gate Failed"
                    }
                }
            }
        }
        stage("Assembly"){
            steps{
                echo "Saving jar in Artifacts and External Directory"
                bat "copy agg\\target\\*.jar C:\\jar\\"
            }
            post {
                always{
                    archiveArtifacts "agg/target/*.jar"
                }
            }
        }
    }
}
