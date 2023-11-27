pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Comandos para construir seu projeto (por exemplo, Maven ou Gradle)
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Comandos para executar testes (por exemplo, JUnit)
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Comandos para implantar sua aplicação (por exemplo, enviar para um servidor)
                    sh 'deploy-script.sh'
                }
            }
        }

        stage('Integration Test') {
            steps {
                script {
                    // Comandos para executar testes de integração
                    sh 'mvn verify'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executado com sucesso!'
        }
        failure {
            echo 'Pipeline falhou. Verifique os logs para mais detalhes.'
        }
    }
}
