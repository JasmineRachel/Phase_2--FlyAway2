const flights_list = "http://localhost:8080/flights"
const users_list = "http://localhost:8080/users"
//TODO: how to return the data??
//when i use return, data appears undefined
async function getCurrentUser(url){

	const response = await fetch(url);
	const data = await response.json();

	return data[data.length -1];

	
};

async function getFlights(url){
	const response = await fetch(url);
	const data = await response.json();
	
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
	console.log("booking info: ", bookingInfo);

	const customerName = document.getElementById("customerName").value;
	const password = document.getElementById("password").value;
	const role = document.getElementById("role").value;
	
	
	customerData = {username: customerName, password: password, role: role}
	// bookingInfo.setItem("customerName", customerName)
	
	// console.log("customer input", data);
	
	fetch('http://localhost:8080/add_user', {
		method: "POST",
		headers:{ "Content-Type": "application/json"},
		body: JSON.stringify(customerData)
	})
	.then((resp) => {
		console.log("create user response status: ", resp.status)
	});
	
	const currentUser = getCurrentUser(users_list)
	console.log("customer created", currentUser)

	bookingData = {
		customerId: currentUser,
		flightId: bookingInfo.getItem("flightId"), 
		travelerTravelers: bookingInfo.getItem("totalTravelers"), 
		totalPrice: bookingInfo.getItem("totalPrice")
	}

	fetch('http://localhost:8080/create_booking', {
		method: "POST",
		headers:{ "Content-Type": "application/json"},
		body: JSON.stringify(bookingData)
	}).then((resp)=>{
		console.log("create booking response status", resp.status)
	});


	// 	const data = await response.json()
	// const users = getUsers(users_list)
	// let length = users.length;
	// console.log("user list length: ", users)
	// const user = `http://localhost:8080/user/${length}`;
	// console.log("current user: ", user)
	// bookingInfo.setItem("customerId", getUsers(user))

	// console.log("customer registered, full flight booking: ", bookingInfo)


}


