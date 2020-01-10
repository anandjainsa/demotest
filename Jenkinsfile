@Library('my-library')_
pipeline {
    agent any

/*    agent {

        label "master"

    }
*/
    tools {

        // Note: this should match with the tool name configured in your jenkins instance (JENKINS_URL/configureTools/)

        maven "maven"
        jdk "jdk1.8.0_131"

    }

    stages {
        stage("Build") {
            steps {
                    mavenBuild();
            }
        }

        stage('Unitesting') {
            steps {
                 sonarRun()
            }
        }

        stage('Building and Pushing Container Image') {
            steps {
                dockerBuild()
            }
        }

        stage("Deploying Application to Dev") {
          when {
    	  expression {
               return env.BRANCH_NAME = 'development';
               }
             }
            steps {
                kubeDeploy("${NAMESPACE}", "${APPNAME}", "${PROJECT}", "${IMAGEVERSION}", "${IMAGETAG}")
            }
        }
    
        stage("Deploying Application to QA") {
          when {
    	  expression {
               return env.BRANCH_NAME = 'qa';
               }
             }
            steps {
                kubeDeploy("${NAMESPACE}", "${APPNAME}", "${PROJECT}", "${IMAGEVERSION}", "${IMAGETAG}")
            }
        }
    }
}
