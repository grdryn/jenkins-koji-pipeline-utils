#!groovy

def call(buildId) {
    def resp = brewReqMethod('listArchives', buildId)
    return valueOfAMember(resp.content, 'filename')
}
