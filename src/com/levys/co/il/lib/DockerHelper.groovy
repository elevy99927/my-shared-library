package com.levys.co.il.lib

class DockerHelper implements Serializable {
    def steps

    DockerHelper(steps) {
        this.steps = steps
    }

    def buildImage(String imageName, String tag = 'latest') {
        steps.sh "docker build -t ${imageName}:${tag} ."
    }

    def pushImage(String imageName, String tag = 'latest') {
        steps.sh "docker push ${imageName}:${tag}"
    }
}
