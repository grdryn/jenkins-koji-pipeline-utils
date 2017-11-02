#!groovy

def call(method,param) {
    return """<?xml version='1.0'?>
        <methodCall>
            <methodName>${method}</methodName>
            <params>
                <param>
                <value><int>${param}</int></value>
                </param>
            </params>
        </methodCall>"""
}
