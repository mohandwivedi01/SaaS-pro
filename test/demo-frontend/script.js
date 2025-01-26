console.log("testing...............")

const baseUrl = "http://localhost:8080/user";

async function submitForm(event) {
    event.preventDefault();
    console.log("clicked...")
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const age = document.getElementById("age").value;
    const salary = document.getElementById("salary").value;
    if(!(name || email || phone || age || salary)){
        alert("All fields are mendatory, please fill all values")
    }else{
        const formData = {
            name,
            email,
            phone,
            age,
            salary,
        };
    
        try{
            const response = await axios.post(`${baseUrl}/add-user`, formData);
            alert("User data submitted successfully!");
            document.getElementById("userForm").reset();
        }catch(error){
            console.error(error);
            alert("Failed to submit data.");
        }
    }
}

async function fetchUserData() {
    try{
        const response = await axios.get(`${baseUrl}/get-user`);
        const user = response.data;
        console.log("user data: ", user)
        const userTable = document.getElementById("userTableBody");
        userTable.innerHTML = ""; //clear existing data
        
        user.forEach((user, index) => {
            const row = `
                <tr class="border-b">
                    <td class="px-4 py-2">${index+1}</td>
                    <td class="px-4 py-2">${user.name}</td>
                    <td class="px-4 py-2">${user.email}</td>
                    <td class="px-4 py-2">${user.phone}</td>
                    <td class="px-4 py-2">${user.age}</td>
                    <td class="px-4 py-2">${user.salary}</td>
                </tr>   
            `;
            userTable.innerHTML += row;
        });
    } catch (error) {
        console.error(error);
        alert("Failed to fetch user data.");
    }
}


function showData(){
    document.getElementById("formData").classList.add("hidden")
    document.getElementById("userData").classList.remove("hidden")
    fetchUserData()
}
function showForm(){
    
    document.getElementById("userData").classList.add("hidden")
    document.getElementById("formData").classList.remove("hidden")
    
}