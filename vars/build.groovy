def dockerBuild(String image, String tag) {
    echo "docker build -t ${image}:${tag} ."
}