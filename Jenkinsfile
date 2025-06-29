pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: '169a99cd-3944-4994-bd72-e8771f1b6b8b', url: 'https://github.com/yashhnk/url-shortener.git', branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t url-shortener-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8080:8080 url-shortener-app'
            }
        }
    }
}
