node{
	website = "";
	resp = getCMDResults("curl ${website}");

	if(!resp.contains("out of stock")){
		sh "curl -H 'Content-Type: application/json' -d '{\"content\":\"In Stock: ${website}\"}' webhookUrl"
	}
}

def getCMDResults(String cmd){
	result = sh (script:cmd,returnStdout: true).trim();
	return result;
}