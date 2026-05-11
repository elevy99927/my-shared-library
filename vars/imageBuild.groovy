def dockerBuild(String image, String tag) {
    echo "docker build -t ${image}:${tag} ."
}

def dockerPush(String image, String tag) {
    echo "docker push ${image}:${tag}"
}