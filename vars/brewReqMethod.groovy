#!groovy

def call(method,param) {
    def data = brewReqText(method,param)
    def resp = brewReq(data) 
    return resp
} 

