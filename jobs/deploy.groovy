def job = pipelineJob('deploy') {
    displayName('deploy')
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
            scriptPath('jobs/pipelines/deploy/Jenkinsfile')
        }
  
    }
    parameters {
        stringParam('WEB_SERVER_NAME', 'web_server1', 'The web server name')
        booleanParam('RUN_TEARDOWN', true, 'Destroy the web server')
    }
}
