def call(tf_workspace) {
    dir(tf_workspace){
        sh "terraform init"
        sh "terraform apply"
    }
}