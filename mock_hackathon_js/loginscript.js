let arr = []
const logindata = () =>
{
fetch('http://localhost:3000/logindata',
{
    method:"Get",
}).then(res=>res.json())
.then(data=>{arr=data})

    
}

const login = () =>
{
    const email = document.getElementById('email').value
    const pass = document.getElementById('pass').value

    if(arr.find(obj => obj.email == email && obj.pass == pass))
	{
        window.location.replace('./main.html')
		}
	else
	{
		alert("Login Rejected")
		}
}