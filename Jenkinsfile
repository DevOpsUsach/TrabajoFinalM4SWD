pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh 'mvnw clean -e'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvnw compile -e'
            }
        }
        stage('Test Unitarios') {
            steps {
                sh 'mvnw test -e'
            }
        }
        /*stage('Test with Selenium Webdriver') {
            steps {
                sh "mvn test -e"
            }
        }*/
    }
}
