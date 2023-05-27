//https://www.tutorialworks.com/jenkins-shared-library/
def call(number) {
    for (i in 1..number) {
        println("Value: $i")
    }
}
