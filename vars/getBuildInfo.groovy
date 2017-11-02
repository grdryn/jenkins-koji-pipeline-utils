#!groovy

def call(buildId) {
    def resp = brewReqMethod('getBuild', buildId)
    def text = resp.content
    return ["package_name": valueOfAMember(resp.content, 'package_name'), "version" : valueOfAMember(resp.content, 'version') , "release" :valueOfAMember(resp.content, 'release')]
}
