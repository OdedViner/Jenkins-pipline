import JobLib.parameters
import JobLib.common

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
        stringParam('HOURS', '12', 'Maximum running time of the cluster (in hours). Clusters older than this will be deleted. The minimum is 10 hours')
    }
}
