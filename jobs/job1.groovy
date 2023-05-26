def job = job('job1') {
    displayName('job1')
    definition {
        cpsScm {
            lightweight(lightweight = false)
            scm {
                git {
                    remote {
                        url('${JOBS_REPOSITORY}')
                    }
                    extensions {
                        wipeOutWorkspace()
                    }
                    branch('${JOBS_REPOSITORY_BRANCH}')
                }
            }
            scriptPath('https://github.com/OdedViner/Jenkins-pipline.git')
        }
  
}
