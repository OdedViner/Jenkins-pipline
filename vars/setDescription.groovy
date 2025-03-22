def call(vars) {
    currentBuild.description = 
    """
    <hr>
    <b>Job Type:</b> ${vars.job_type}<br />
    <hr />
    """
}