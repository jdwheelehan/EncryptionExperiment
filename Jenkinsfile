pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'echo "Run Build"'
      }
    }
    stage('Perform Unit Tests') {
      when {
        branch 'develop'
      }
      steps {
        sh 'echo "run unit tests"'
      }
    }
    stage('Upload Artifact') {
      steps {
        archiveArtifacts(allowEmptyArchive: true, artifacts: '**/target/*.jar')
      }
    }
    stage('Deploy to Dev and test') {
      when {
        branch 'develop'
      }
      steps {
        sh '''./jenkins/deploy.sh${params.DEPLOY_TO}
        echo "Deployed to Dev"'''
        sh 'echo "run integration test"'
      }
    }
    stage('Deploy To QA') {
      when {
        branch 'develop'
      }
      steps {
        sh 'echo "Deploy to QA"'
        sh 'echo "Run integration tests"'
      }
    }
    stage('Create Release Branch') {
      when {
        branch 'develop'
      }
      steps {
        echo 'Release Branch Create'
      }
    }
    stage('Tag Master With Release') {
      when {
        branch 'release'
      }
      steps {
        echo 'Release Branch Tagged To Master'
      }
    }
    stage('Post to XLR') {
      when {
        branch 'release'
      }
      steps {
        echo 'Deployed to Prod'
      }
    }
  }
}