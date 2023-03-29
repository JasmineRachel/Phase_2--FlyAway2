const flights_list = "http://localhost:8080/flights"

async function getFlights(url){
	const response = await fetch(url);
	var data = await response.json();
	
	console.log("data:", data);
	
	let table = "";
	
	data.forEach((flight) => {
		table +="<tr>";
		table +="<td style='display:none;'> <input type='text' id='flightId' name='flightId' value=" + flight.id + " readonly /> </td>";
		table +="<td>" + flight.destination.locationName + "</td>";
		table +="<td>" + flight.airlineId.airlineName + "</td>";
		table +="<td>" + flight.date + "</td>";
		table +="<td>" + "<input type='text' id='price' name='price' value=" + flight.price + " readonly />" + "</td>";
		table +="<td> <input id='travelerNo' type='text' name='travelerNo'</td>";
		table +="<td> <input type='button' onclick='return createBooking()' value='Book this flight!'/></td></tr>";
	});
	
	document.getElementById('flights_data').innerHTML = table;
}

const locations = getFlights(flights_list);

function createBooking() {
	
	const flightId = document.getElementById("flightId").value;
	const flightPrice = document.getElementById("price").value;
	const travelerNo = document.getElementById("travelerNo").value;
	const totalPrice = flightPrice * travelerNo;

	console.log("input: id:", flightId, ", flightPrice: ", flightPrice, ", persons: ", travelerNo, ", totalPrice: ",  totalPrice);
	
	//TODO: work out how you're going to add the user's data to the same entry that the flight booking details will!!!

	// async function createBooking(url, flightId, travelerNo, totalPrice){
	// 	data = {flightId: flightId, travelerNo: travelerNo, totalPrice: totalPrice}
	// 	const response = await fetch(url, {
	// 		method: "POST",
	// 		headers:{ "Content-Type": "application/json"},
	// 		body: JSON.stringify(data)
	// 	});
	// 	const data = await response.json()
	// }
}



// function updateTextInput(val) {
//   document.getElementById('textInput').value=val; 
// }

