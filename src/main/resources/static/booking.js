const flights_list = "http://localhost:8080/flights"
const users_list = "http://localhost:8080/users"
//TODO: how to return the data??
//when i use return, data appears undefined
function getUsers(url){
	const data = fetch(url)
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
	return data;
};

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
		table +="<td> <input id='totalTravelers' type='text' name='totalTravelers'</td>";
		table +="<td> <input type='submit' onclick='return createBooking()' value='Book this flight!'/></td></tr>";
	});
	
	document.getElementById('flights_data').innerHTML = table;
};

getFlights(flights_list);

//using sessionStorage to tempararily store the customer's booking details 
const bookingInfo = window.sessionStorage;
function createBooking() {
	
	const flightId = document.getElementById("flightId").value;
	const flightPrice = document.getElementById("price").value;
	const totalTravelers = document.getElementById("totalTravelers").value;
	const totalPrice = flightPrice * totalTravelers;

	console.log("input: id:", flightId, ", flightPrice: ", flightPrice, ", persons: ", totalTravelers, ", totalPrice: ",  totalPrice);

	bookingInfo.setItem("flightId", parseInt(flightId));
	bookingInfo.setItem("totalTravelers", parseInt(totalTravelers));
	bookingInfo.setItem("totalPrice", totalPrice);

	console.log("populated booking info: ", bookingInfo);
	
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
//one way to get the current user (there must be a better way!)
//get all users and retrieve the length:
//currentUserId = userList.length. So..
//url = http://localhost:8080/users ${curentUserId}'

async function registerCustomer(){
	const customerName = document.getElementById("customerName").value;
	const password = document.getElementById("password").value;
	const role = document.getElementById("role").value;
	
	
	data = {username: customerName, password: password, role: role}
	// bookingInfo.setItem("customerName", customerName)
	
	// console.log("customer input", data);
	
	const response = await fetch('http://localhost:8080/add_user', {
		method: "POST",
		headers:{ "Content-Type": "application/json"},
		body: JSON.stringify(data)
	});

	console.log("customer created", getUsers(users_list))
	// const users = getUsers(users_list)
	// let length = users.length;
	// console.log("user list length: ", users)
	// const user = `http://localhost:8080/user/${length}`;
	// console.log("current user: ", user)
	// bookingInfo.setItem("customerId", getUsers(user))

	// console.log("customer registered, full flight booking: ", bookingInfo)


}

// console.log("booking info", bookingInfo);


// function updateTextInput(val) {
//   document.getElementById('textInput').value=val; 
// }

