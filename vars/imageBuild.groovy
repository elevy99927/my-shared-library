def dockerBuild(String image, String tag) {
    echo "docker build -t ${image}:${tag} ."
}

dockerPush(String image, String tag) {
    echo "docker push ${image}:${tag}"
}