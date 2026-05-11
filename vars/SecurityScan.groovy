def trivyRemoteScan(String image, String tag) {
    sh "trivy image ${image}:${tag}"
}

def trivyLocalScan() {
    echo "trivy fs ."
}


def banditLocalScan() {
    echo "bandit -r ."
}


