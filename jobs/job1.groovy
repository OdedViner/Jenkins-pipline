import ocsJobLib.common

def job = pipelineJob('job1 new') {
    displayName('job1 new')
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
    parameters {
        stringParam('HOURS', '12', 'Maximum running time')
    }
}
