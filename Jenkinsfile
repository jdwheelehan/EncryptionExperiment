pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Perform Unit Tests') {
      when {
        branch 'develop'
      }
      steps {
        sh 'mvn test'
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