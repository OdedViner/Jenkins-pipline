package JobLib

import javaposse.jobdsl.dsl.Job


class parameters {
    /*
      Parameters could use the String Validator Parameters, that requires this plugin:
      https://plugins.jenkins.io/validating-string-parameter/
      Before editing/adding String Validator Parameters, please refer to those docs/polls:
      https://stackoverflow.com/questions/58536826/how-to-use-validating-string-parameter-plugin-in-the-jenkins-declarative-pipelin/67882073#67882073
      https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    */
    static jobRepository = "https://github.com/OdedViner/Jenkins-pipline.git"
    
// PARAMETERS:
    static void jobs_repository_params(paramContext,
        jobsRepository=parameters.jobRepository,
        jobsRepositoryBranch="main"
    ) {
        paramContext.with {
            stringParam('JOBS_REPOSITORY', jobsRepository, 'Jobs Repository to clone')
            stringParam('JOBS_REPOSITORY_BRANCH', jobsRepositoryBranch, 'Name of branch from Jobs Repository to checkout')
        }
    }
    

