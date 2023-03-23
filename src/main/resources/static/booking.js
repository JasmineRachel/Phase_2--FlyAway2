const api_url = "http://localhost:8080/locations"

async function getLocations(url){
	const response = await fetch(url);
	var data = await response.json();
	
	console.log("data:", data);
	
	 function myFunction(value){
		sourceSelect = document.getElementById('outbound_location');
		sourceSelect.options[sourceSelect.options.length] = new Option(value.locationName);
		
		destinationSelect = document.getElementById('inbound_location');
		destinationSelect.options[destinationSelect.options.length] = new Option(value.locationName);
		console.log(value.locationName);
	}
	
	data.forEach(myFunction);	
}

const locations = getLocations(api_url);

