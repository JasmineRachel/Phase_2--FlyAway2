const api_url = "http://localhost:8080/flights"

async function getLocations(url){
	const response = await fetch(url);
	var data = await response.json();
	
	console.log("data:", data);
	
	 //function myFunction(value, ){
		//sourceSelect = document.getElementById('outbound_location');
		//sourceSelect.options[sourceSelect.options.length] = new Option(value.locationName);
		
		//destinationSelect = document.getElementById('inbound_location');
		//destinationSelect.options[destinationSelect.options.length] = new Option(value.locationName);
		
				
	//}
	
	//data.forEach(myFunction);	
	let table = "";
	
	data.forEach((flight) => {
		table +="<tr>";
		table +="<td>" + flight.destination.locationName + "</td>";
		table +="<td>" + flight.airlineId.airlineName + "</td>";
		table +="<td>" + flight.date + "</td>";
		table +="<td>" + flight.price + "</td>";
		table +="<td> <input type='submit' value='Book your flight!'/></td></tr>";
	});
	
	document.getElementById('flights_data').innerHTML = table;
}

const locations = getLocations(api_url);

function updateTextInput(val) {
  document.getElementById('textInput').value=val; 
}

