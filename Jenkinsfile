pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh './mvnw clean -e'
            }
        }
        stage('Compile') {
            steps {
                sh './mvnw compile -e'
            }
        }
        stage('Test Unitarios') {
            steps {
                sh './mvnw test -e'
            }
        }
        stage('Ejecutar') {
            steps {
                sh 'JENKINS_NODE_COOKIE=dontKillMe nohup bash mvnw spring-boot:run -Dspring-boot.run.jvmArguments=-Dserver.port=8090 &'
                sleep 10
            }
        }
        stage('Smoke Test') {
            steps {
                sh "curl -X GET 'http://localhost:8090/rest/msdxc/'"
            }
        }
        stage('Test WS con Newman') {
            steps {
                nodejs('NodeJS4Newman') {
                    sh 'newman run TrabajoFinalM4SWD.postman_collection.json'
                }
            }
        }
        /*stage('Test with Selenium Webdriver') {
            steps {
                sh "mvn test -e"
            }
        }*/
    }
}
