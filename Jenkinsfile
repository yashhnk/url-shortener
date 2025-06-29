pipeline {
    agent any

    environment {
        IMAGE_NAME = 'url-shortener-app'
        CONTAINER_NAME = 'url-shortener-container'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', credentialsId: '169a99cd-3944-4994-bd72-e8771f1b6b8b', url: 'https://github.com/yashhnk/url-shortener.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Run Docker Container') {
            steps {
                sh """
                    docker rm -f ${CONTAINER_NAME} || true
                    docker run -d --name ${CONTAINER_NAME} -p 8081:8080 ${IMAGE_NAME}
                """
            }
        }
    }
}
