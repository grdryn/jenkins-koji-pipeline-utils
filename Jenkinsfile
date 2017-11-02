#!/usr/bin/groovy

import org.kohsuke.github.GHOrganization
import org.kohsuke.github.GHUser
import org.kohsuke.github.GitHub
import org.kohsuke.github.GitHubBuilder

final boolean isOrgMember(String user, String org, String gitHubCredentialsId) {
    node {
        withCredentials([usernamePassword(
                    credentialsId: gitHubCredentialsId,
                    passwordVariable: 'GITHUB_PASSWORD',
                    usernameVariable: 'GITHUB_USERNAME')]) {
            final GitHub gitHub = new GitHubBuilder()
                .withOAuthToken(env.GITHUB_PASSWORD, env.GITHUB_USERNAME)
                .build()

            final GHUser ghUser = gitHub.getUser(user)
            final GHOrganization ghOrganization = gitHub.getOrganization(org)
            return ghUser.isMemberOf(ghOrganization)
        }
    }
}

stage('Trust') {
    /*
     * This is copied from 'enforceTrustedApproval',
     * because using that here would not be trustworthy
     */

    if (!env.CHANGE_AUTHOR) {
        println "This doesn't look like a GitHub PR, continuing"
    } else if (!isOrgMember(env.CHANGE_AUTHOR, 'fheng', 'githubjenkins')) {
        input(
            message: "Trusted approval needed for change from ${env.CHANGE_AUTHOR}",
            submitter: 'authenticated'
        )
    } else {
        println "${env.CHANGE_AUTHOR} is trusted, continuing"
    }
}

node {
    env.BRANCH_NAME = env.BRANCH_NAME ?: 'master'
    String gitref = env.CHANGE_ID ? "pr/${env.CHANGE_ID}" : env.BRANCH_NAME
    def fhPipelineLibrary = library("fh-pipeline-library@${gitref}")
}
