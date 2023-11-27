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
                    // Comandos para construir Maven
                    echo 'Build da Imagem mvn spring-boot:build-image'
                    
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Comandos para executar testes (por exemplo, JUnit)
                    echo 'Execução dos Testes da app (sh mvn test)'
                    
                }
            }
        }
           stage('Sonar') {
            steps {
                script {
                    // Comandos para analise do sonar
                    echo 'Configurar Sonar'
                    
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Comandos para implantação
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
