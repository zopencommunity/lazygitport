node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/lazygitport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/lazygitport.git'), string(name: 'PORT_DESCRIPTION', value: 'UI for git commands' ), string(name: 'BUILD_LINE', value: 'DEV'), string(name: 'NODE_LABEL', value: "go_120" )  ]
  }
}
