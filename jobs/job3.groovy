def job = pipelineJob('job3') {
    displayName('job3')
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
            scriptPath('jobs/pipelines/job3/Jenkinsfile')
        }
  
    }
    parameters {
        stringParam('HOURS', '44', 'Maximum running time')
    }
}
