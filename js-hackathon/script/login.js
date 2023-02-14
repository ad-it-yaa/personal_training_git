console.log("Page Loaded")
let arr = []

const logindata = () =>
{
fetch('http://localhost:3000/User',
{
    method:"Get",
}).then(res=>res.json())
.then(data=>{arr=data})

    
}

const login = () =>
{
    const id = document.getElementById('id').value
    const pass = document.getElementById('pass').value



    if(arr.find(obj => obj.id == id && obj.pass == pass))
	{
        
		const data = arr.filter(obj => obj.id ==id)
		sessionStorage.setItem("Phone", data[0].mobile)
		sessionStorage.setItem("Address", data[0].address)
		sessionStorage.setItem("Account", data[0].account)
		sessionStorage.setItem("Name", data[0].name)
		sessionStorage.setItem("ID", data[0].id)
		window.location.replace('../page/loan.html')
   }
	
	
		
	else
	{
		document.getElementById('failed').innerHTML = "Please enter a valid username & password"
		document.getElementById('id').value = ""
		document.getElementById('pass').value = ""
		}


}