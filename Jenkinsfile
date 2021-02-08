pipeline {
  agent any
  environment {
    name = 'davidperez01/downscrapyservice'
  }
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/nonave/DownScrapyService.git', branch: 'main', changelog: true)
      }
    }
    stage('Clean') {
      agent any
      steps {
        echo "Nombre del proyecto: ${name}"
        echo 'Clean mvn'
        sh 'mvn clean -DskipTests=true'
      }
    }
    stage('Test') {
      agent any
      steps {
        echo 'Test Project'
        sh 'mvn test'
      }
    }
    stage('Build & Docker') {
      agent any
      steps {
        echo 'mvn Build'
        sh 'mvn install -DskipTests=true'
        echo 'Docker Imagen'
        sh "docker image build -t ${name} ."
      }
    }
    stage('Docker Register') {
      agent any
      environment {
        registry = "${name}"
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Register Docker'
        echo "registry: ${registry}"
      }
    }
  }
  post {
    success {
      slackSend(color: 'good', channel:'nonave', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Funcionó correctamente")
      slackSend(color: 'good', channel:'desarrollo', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Funcionó correctamente")
    }
    failure {
      slackSend(color: 'danger', channel:'nonave', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Hubo un problema con el deploy")
      slackSend(color: 'good', channel:'desarrollo', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Funcionó correctamente")
    }
  }
}
