def job = pipelineJob('job1') {
    displayName('job1')
    definition {
        cpsScm {
            lightweight(lightweight = false)
            scm {
                git {
                    remote {
                        url('https://github.com/OdedViner/Jenkins-pipline.git')
                    }
                    extensions {
                        wipeOutWorkspace()
                    }
                    branch('main')
                }
            }
            scriptPath('jobs/pipelines/job1/Jenkinsfile')
        }
    }
    // parameters {
    //     parameters.cluster_name_param delegate
    // }
    // environmentVariables {
    //     keepSystemVariables(true)
    //     keepBuildVariables(true)
    // }
}
