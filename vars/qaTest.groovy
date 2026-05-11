def runSimpleTests() {
    echo "Run simple test"
}

def newmanLocalTest(String collection) {
    echo "newman run ${collection}" 
}

def newmanRemoteTest(String testsRepo, String collection, String apikey) {
    echo "newman run ${testsRepo}/${collection}?apikey=${apikey}" 
}