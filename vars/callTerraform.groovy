def call(tf_workspace) {
    data = [:] 
    dir(tf_workspace){
        sh "terraform init"
        sh "terraform apply --auto-approve"
      data['ip_address'] = sh (
        script: """terraform output ip_address | tr -d '"'""",
        returnStdout: true
      ).trim()
      data['tf_workspace_path'] = sh (
        script: "pwd",
        returnStdout: true
      ).trim()
      println data
    }
}