def call(NAMESPACE, APPNAME, PROJECT, IMAGEVERSION, IMAGETAG)
{
    script {

        switch (NAMESPACE) {
        //Roll out to Dev Environment
//            case "development":
                // Create namespace if it doesn't exist
                sh("kubectl get ns ${NAMESPACE}")
             //   sh("kubectl get ns ${NAMESPACE} || kubectl create ns ${NAMESPACE}")
                //Update the imagetag to the latest version
                sh("sed -i.bak 's#name:#name: ${APPNAME}#' ./k8s/development/*.yaml")
                sh("sed -i.bak 's#app:#app: ${APPNAME}#' ./k8s/development/*.yaml")
                sh("sed -i.bak 's#apps:#apps: ${APPNAME}#' ./k8s/development/*.yaml")
                sh("sed -i.bak 's#oncallservices/${PROJECT}:${IMAGEVERSION}#${IMAGETAG}#' ./k8s/development/*.yaml")
                //Create or update resources
                sh("kubectl --namespace=${NAMESPACE} apply -f k8s/development/deployment.yaml")
                sh("kubectl --namespace=${NAMESPACE} apply -f k8s/development/service.yaml")
        }

    }
}
