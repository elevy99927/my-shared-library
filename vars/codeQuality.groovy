def sonarqubeScan(){
    echo "Scan with Sonarqube"
} 

def sonarLocalScan() {
    withSonarQubeEnv('SonarQube') {

        sh """
            sonar-scanner \
              -Dsonar.projectKey=${env.JOB_NAME} \
              -Dsonar.projectName=${env.JOB_NAME} \
              -Dsonar.sources=. \
              -Dsonar.sourceEncoding=UTF-8
        """
    }
}


def sonarLocalScanWithGate() {
    withSonarQubeEnv('SonarQube') {

        sh """
            sonar-scanner \
              -Dsonar.projectKey=${env.JOB_NAME} \
              -Dsonar.projectName=${env.JOB_NAME} \
              -Dsonar.sources=. \
              -Dsonar.sourceEncoding=UTF-8
        """
    }

    timeout(time: 5, unit: 'MINUTES') {
        def qualityGate = waitForQualityGate()

        if (qualityGate.status != 'OK') {
            error "SonarQube Quality Gate failed: ${qualityGate.status}"
        }
    }
}