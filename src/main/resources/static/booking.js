const flights_list = "http://localhost:8080/flights"

async function getFlights(url){
	const response = await fetch(url);
	var data = await response.json();
	
	console.log("data:", data);
	
	let table = "";
	
	data.forEach((flight) => {
		table +="<tr>";
		table +="<td style='display:none;'> <input type='text' id='flightId' name='flightId' value=" + flight.id + "/> </td>";
		table +="<td>" + flight.destination.locationName + "</td>";
		table +="<td>" + flight.airlineId.airlineName + "</td>";
		table +="<td>" + flight.date + "</td>";
		table +="<td>" + " £" + flight.price + "</td>";
		table +="<td> <input id='travelerNo' type='text' name='travelerNo'</td>";
		table +="<td> <input type='submit' value='Book this flight!'/></td></tr>";
	});
	
	document.getElementById('flights_data').innerHTML = table;
}

const locations = getFlights(flights_list);

function getFormValue() {
	const flightId = document.getElementById("flightId").value;
	const travelerNo = document.getElementById("travelerNo").value;
	console.log("input: ", flightId + travelerNo);
}
//add the total price 
async function createBooking(url, flightId, travelerNo){
	data = {flightId: flightId, travelerNo: travelerNo, totalPrice: ""}
	const response = await fetch(url, {
		method: "POST",
		headers:{ "Content-Type": "application/json"},
		body: JSON.stringify(data)
	});
	const data = await response.json()
}

createBooking();
// function updateTextInput(val) {
//   document.getElementById('textInput').value=val; 
// }

