def call(
  tf_action,
  tf_workspace
) {
    if (tf_action == 'apply') {
        sh "mkdir -p ${tf_workspace}"
        sh "cp -R ${tf_source_dir}/* ${tf_workspace}"
    }


}