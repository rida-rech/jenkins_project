def call(commerceDir, branch, projectRepository) {
    urlPrefix = "https://"
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'githubCodeRepoCredentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {        
        repoDomainPart = projectRepository.substring(urlPrefix.size())
        repository = "https://github.com/SAP-samples/cloud-commerce-sample-setup.git"
        echo "##### Checkout repository #####"
		 sh "git clone ${repository} . && git fetch --all && git checkout origin/${branch}"       
    }
}