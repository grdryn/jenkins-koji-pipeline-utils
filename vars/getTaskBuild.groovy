#!groovy

def call(id) {
    def resp = brewReqMethod('getTaskResult',id)
    return valueOfAMember(resp.content,'koji_builds')
}

