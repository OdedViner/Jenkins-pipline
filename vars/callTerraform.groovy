def call(tf_action, tf_workspace, web_name=null) {
    data = [:]
    dir(tf_workspace){
        if (tf_action == 'apply') {
            sh "terraform init"
            sh "terraform apply -var vm_name=${web_name} --auto-approve"
            data['ip_address'] = sh (
                script: """terraform output PrivateIP | tr -d '"'""",
                returnStdout: true
            ).trim()
            data['tf_workspace_path'] = sh (
                script: "pwd",
                returnStdout: true
            ).trim()
            println data
            return data
        }
        if (tf_action == 'destroy'){
            sh "terraform destroy --auto-approve"
        }
    }
}