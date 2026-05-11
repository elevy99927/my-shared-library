def helmDeploy(String chart, String appname, String image, String tag) {
    echo "helm upgrade --install ${appname} ${chart} --set image  ${image} --set tag ${tag}"
}

def argoDeploy(String chart, String appname, String image, String tag) {
    echo "helm template and git push (TBD)"
}




