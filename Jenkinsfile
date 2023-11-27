pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'checkout do repositorio da app'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Comandos para construir seu projeto (por exemplo, Maven ou Gradle)
                    echo 'Build da Imagem mvn spring-boot:build-image'
                    
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Comandos para executar testes (por exemplo, JUnit)
                    echo 'Execução dos Testes da app (sh mvn teste)'
                    
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Comandos para implantar sua aplicação (por exemplo, enviar para um servidor)
                    echo 'docker run container (docker run --network="host" -p 8082:8082 IDimagem)'
                }
            }
        }

        stage('Testes de Integração') {
            steps {
                script {
                    // Comandos para executar testes de integração com MYSQL, RABBITMQ, REDIS, Keyclock
                     echo 'executar testes de integração'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executado com sucesso!'
        }
        failure {
            echo 'Pipeline falhou. Analise os Logs.'
        }
    }
}
