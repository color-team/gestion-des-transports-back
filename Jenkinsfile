pipeline {
    agent any
    tools {
        maven 'maven-tool'
    }
    stages {
        stage( 'build') {
            steps {
            	sh 'clean install'
                sh 'mvn clean package'
            }
        }
    }
    post {
        success {
            script {
                if ("${env.BRANCH_NAME}" == 'master')
                    discordSend description: "${BUILD_URL} \n Commit : ${env.GIT_COMMIT}", footer: 'yay', image: '', link: '', result: 'SUCCESS', thumbnail: '', title: "${env.JOB_NAME}", 
                    webhookURL: 'https://discordapp.com/api/webhooks/748537911590387713/BHrxH7Xgr29tj__E2NmdYr6Ngm_81hVFgfkN-xcWyMPcYVSmXdrxlRbVeQzQz1oq53Tr'
            }
        }
        failure {
            discordSend description: "${BUILD_URL} \n Commit : ${env.GIT_COMMIT}", footer: 'shit', image: '', link: '', result: 'FAILURE', thumbnail: '', title: "${env.JOB_NAME}",
            webhookURL: 'https://discordapp.com/api/webhooks/748537911590387713/BHrxH7Xgr29tj__E2NmdYr6Ngm_81hVFgfkN-xcWyMPcYVSmXdrxlRbVeQzQz1oq53Tr'
        }
    }
}