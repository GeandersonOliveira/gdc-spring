
pipeline {
  agent none

 
        stage('Configurar Build') {
          
          steps {
            script {
              echo "Configurar Build do APP"
              
          }
        }
        }

       
        stage('Testes') {
         
          steps {
            script {
              echo "executar testes (mvn test)"
              }
             }

        }
        stage('Sonar') {
          
          steps {
            script {
              echo "Configurar Sonar"
              }
          }
        }
        
     
    stage("CD") {
      stages {
        stage('Build da Imagem') {
          
          }
          
          steps {
            script {
             echo " mvn spring-boot:build-image"
            }
          }
          }
        }//stage
        

        stage('Deploy') {
          
          agent "any"
          steps {
            script {
               echo " docker run "
            }//script
          }//steps
        }//stage
        
}//pipeline
