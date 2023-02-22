function authen(){
    
    let auth = [
        {
            "id":"001",
            "name":"Kirtan",
            "pin":"123456",
            "number":"827473293",
            "Email":"Kirtan@123",
            "Adhaar":"12345678",
            "status":"Sucess"


        },
        {
            "id":"002",
            "name":"Gourav",
            "pin":"654321",
            "number":"8923794390",
            "Email":"Gourav@123",
            "Adhaar":"123456789",
            "status":"Pending"
        },
        {
            "id":"003",
            "name":"Manvith",
            "pin":"6543210",
            "number":"3879842421",
            "Email":"Manvith@123",
            "Adhaar":"0123456789",
            "status":"Sucess"
        }



        
    ]
    let uid=document.forms['login'].id.value;
    let uname=document.forms['login'].name.value;
    let upin=document.forms['login'].pin.value;
    let uAcc=document.forms['login'].number.value;
    let uEmail=document.forms['login'].mail.value;
    let uAdhaar=document.forms['login'].Adhaar.value;
    let uStatus=document.forms['login'].status.value

    document.getElementById("notFound").innerHTML = "User not found";

    auth.forEach((item) => {
        if(item.id == uid){
            document.getElementById("notFound").innerHTML = "";

            if(item.name == uname && item.pin == upin && item.number == uAcc && item.Email == uEmail && item.Adhaar == uAdhaar && item.status == uStatus){ 
                window.location.href = "http://127.0.0.1:5501/home.html"
            }
            else{
                //Checking if other details match
                if(item.name!=uname){
                    document.getElementById("name").innerHTML = "Name doesn't match";
                }
                else{
                    document.getElementById("name").innerHTML = "";
                }
                if(item.pin!=upin){
                    document.getElementById("pin").innerHTML = "ID doesn't match";
                }
                else{
                    document.getElementById("pin").innerHTML = "";
                }
                if(item.number!=uAcc){
                    document.getElementById("number").innerHTML = "ID doesn't match";
                }
                else{
                    document.getElementById("number").innerHTML = "";
                }
                if(item.Email!=uEmail){
                    document.getElementById("mail").innerHTML = "ID doesn't match";
                }
                else{
                    document.getElementById("mail").innerHTML = "";
                }
                if(item.Adhaar!=uAdhaar){
                    document.getElementById("aadhaar").innerHTML = "ID doesn't match";
                }
                else{
                    document.getElementById("aadhaar").innerHTML = "";
                }
                if(item.status!=uStatus){
                    document.getElementById("status").innerHTML = "ID doesn't match";
                }
                else{
                    document.getElementById("status").innerHTML = "";
                }

            }
        }
        
    });

}