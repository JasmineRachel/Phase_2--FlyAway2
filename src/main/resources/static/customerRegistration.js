
const users_list = "http://localhost:8080/users"

function getUsers(url){
	fetch(url)
	.then((response) => response.json())
	.then((result) => result = result);

	return result;
};

async function registerCustomer(){
	const customerName = document.getElementById("customerName").value;
	const password = document.getElementById("password").value;
	const role = document.getElementById("role").value;
    
	console.log("all users", getUsers(users_list))
	
	data = {username: customerName, password: password, role: role}
	// bookingInfo.setItem("customerName", customerName)
	
	// console.log("customer input", data);
	
    await fetch('http://localhost:8080/add_user', {
        method: "POST",
        headers:{ "Content-Type": "application/json"},
        body: JSON.stringify(data)
    });

	
	const usersAll = getUsers(users_list)
	let length = users.length;
	console.log("user list length: ", usersAll)
	// const user = `http://localhost:8080/user/${length}`;
	// bookingInfo.setItem("customerId", getUsers(user))

	// console.log("customer registered, full flight booking: ", bookingInfo)


}