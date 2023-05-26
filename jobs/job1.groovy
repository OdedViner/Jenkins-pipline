def job = pipelineJob(jobConfig['name']) {
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
            scriptPath('jobs/pipelines/job1/Jenkinsfile')
        }
    }
    parameters {
        parameters.cluster_name_param delegate
    }
    environmentVariables {
        keepSystemVariables(true)
        keepBuildVariables(true)
    }
}
