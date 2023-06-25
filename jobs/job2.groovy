def job = pipelineJob('job2') {
    displayName('job2')
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
            scriptPath('jobs/pipelines/job2/Jenkinsfile')
        }
  
    }
    parameters {
        stringParam('HOURS', '14', 'Maximum running time')
    }
}
