console.log("Page Loaded!")
const adduser = () => {

    
    const fname = document.getElementById('fname').value
    const lname = document.getElementById('lname').value
    const id = document.getElementById('uname').value
    const address = document.getElementById('address').value
    const rollno = document.getElementById('rollno').value
    const phone = document.getElementById('phone').value
    const email = document.getElementById('email').value
    const pass = document.getElementById('pass').value
    
    newuser = {
        "fname":fname,
        "lname":lname,
        "id":id,
        "address":address,
        "rollno":rollno,
        "phone":phone,
        "email":email,
        "pass":pass
    }
if(fname=='' || lname=='' || id=='' || address=='' || rollno=='' || phone=='' || phone.length==9 ||  email=='' || pass=='')
{
    alert("Please fill all the details before submitting ")
}
else
{
fetch('http://localhost:3000/logindata', 
{
    method:"POST",
    headers:
    {
        "content-Type":"application/json"
    },
    body: JSON.stringify(newuser)
}).then(res => {
    window.location.replace('./main.html')
    console.log(res);
})
 .catch(error => console.log(error))
}
}
