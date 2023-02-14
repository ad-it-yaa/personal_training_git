function displaydata()
{
const username = sessionStorage.getItem('Name')
const account = sessionStorage.getItem('Account')
const id = sessionStorage.getItem('ID')
const phone = sessionStorage.getItem('Phone')
const address = sessionStorage.getItem('Address')


document.getElementById('uname').innerHTML = username
document.getElementById('account').innerHTML = account
document.getElementById('phone').innerHTML = phone
document.getElementById('email').innerHTML = id
document.getElementById('address').innerHTML = address
}