node{
	website = getCMDResults("curl -XGET url");

	if(!website.contains("term")){
		sh "curl webhook"
	}
}

def getCMDResults(String cmd){
	result = sh (script:cmd,returnStdout: true).trim();
	return result;
}