#!groovy

def call(data) {
  return httpRequest(httpMode: 'POST',
    contentType: 'APPLICATION_JSON',
    requestBody: data,
    customHeaders: [],
    url: "http://brewhub.engineering.redhat.com/brewhub",
    validResponseCodes: '100:399')
}

