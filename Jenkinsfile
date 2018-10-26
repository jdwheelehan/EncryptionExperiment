pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'echo "Run Build"'
      }
    }
    stage('Run Testing') {
      parallel {
        stage('Perform Unit Tests') {
          steps {
            sh 'echo "run unit tests"'
          }
        }
        stage('Checkmarx Scan') {
          steps {
            sh 'echo "Run Checkmarx Scan"'
          }
        }
        stage('Sonarqube Check') {
          steps {
            sh 'echo "Run Sonarqube"'
          }
        }
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
        sh 'echo "Deployed to Dev"'
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
    stage('Merge Release with Master') {
      when {
        branch 'release'
      }
      steps {
        sh 'echo "Merge to Master"'
      }
    }
    stage('Post to XLR') {
      when {
        branch 'master'
      }
      steps {
        sh 'echo "Post to XLR"'
      }
    }
  }
}