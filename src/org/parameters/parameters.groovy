package org.parameters

// https://www.jenkins.io/doc/book/pipeline/shared-libraries/

class parameters {
    static void registry_image(paramContext, defaultValue='') {
        paramContext.with {
            stringParam(
                'REGISTRY_IMAGE',
                defaultValue,
                'Registry image to utilize'
            )
        }
    }
}
