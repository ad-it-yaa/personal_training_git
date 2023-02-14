console.log("Page Loaded!")
const adduser = () =>
{
    const id = document.getElementById('id').value
    const uname = document.getElementById('name').value
    const address = document.getElementById('address').value
    const account = document.getElementById('account').value
    const mobile = document.getElementById('mobile').value
    const pass = document.getElementById('pass').value

User =
 {
        "id":id,
        "name":uname,
        "address":address,
        "account":account,
        "mobile":mobile,
        "pass":pass
}

const regex = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g);
if(regex.test(id)==false || uname == '' || address == '' || account == '' || pass == '' || mobile.length < 9)
{
   document.getElementById('failed').innerHTML = "Please fill all the fields before submitting"
}
else
{
    fetch('http://localhost:3000/User', 
    {
        method:"POST",
        headers:
        {
            "content-Type":"application/json"
        },
        body: JSON.stringify(User)
    }).then(res => {
        window.location.replace('../page/login.html')
        console.log(res);
    })
     .catch(error => console.log(error))
    }
    }
    