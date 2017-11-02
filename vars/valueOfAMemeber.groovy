#!groovy

def call(content, name) {
    def test = new XmlSlurper().parseText(content)    
    def koji_state_member =  test.'**'.find { node -> node.name.text() == name }
    def koji_state_value = koji_state_member.'**'.find { node -> node.name() == 'value' }
    return "${koji_state_value}"
}
