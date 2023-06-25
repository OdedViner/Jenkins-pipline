def job = job('main-seed-job') {
    displayName('Main Seed Job for DSL Jobs')
    parameters {
        stringParam('JOBS_REPOSITORY', 'https://github.com/OdedViner/Jenkins-pipline.git', 'Jobs Repository to clone')
        stringParam('JOBS_REPOSITORY_BRANCH', 'main', 'Name of branch from Jobs Repository to checkout')
        booleanParam('JOBS', true, 'Generate jobs')
        stringParam('JOBS_PATH', 'jobs/*.groovy', 'Path to Job DSL definition files (default: jobs/*.groovy)')
    }
    scm {
        git {
            branch('${JOBS_REPOSITORY_BRANCH}')
            remote {
                name('origin')
                url('${JOBS_REPOSITORY}')
            }
        }
    }
    steps {
        shell('echo "JOBS: ${JOBS}"')
        shell('echo "JOBS_PATH: ${JOBS_PATH}"')
        conditionalSteps {
            condition {
                booleanCondition('${JOBS}')
            }
            runner("Run")
            steps {
                shell('echo "Generating jobs."')
                dsl {
                    external('${JOBS_PATH}')
                    additionalClasspath(['src/org/parameters', ].join('\n'))
                    removeAction('IGNORE')
                }
            }
        }
    }
}

// This accepts changes in the script approval section of 'Manage Jenkins'.  You may or may not want this.
org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get().with { approval ->
    approval.preapproveAll()
    approval.save()
}
