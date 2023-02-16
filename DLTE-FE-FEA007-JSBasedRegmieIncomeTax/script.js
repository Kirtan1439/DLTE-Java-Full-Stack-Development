function calculate(){
    let fname = document.forms['tax'].name.value;
    let fsal = document.forms['tax'].salary.value;

    if(fsal<300000){
        document.getElementById("output").innerHTML=fname+" don't need to pay tax"
     }
    else if(fsal>=300000 && fsal<600000){
        document.getElementById("output").innerHTML=fname+" has to pay Rs."+ fsal*0.05 +" as of 5% tax rate." 

    }
    else if(fsal>=600000 && fsal<900000){
        document.getElementById("output").innerHTML=fname+" has to pay Rs."+ fsal*0.10 +" as of 10% tax rate." 
    }
    else if(fsal>=900000 && fsal<1200000){
        document.getElementById("output").innerHTML=fname+" has to pay Rs."+ fsal*0.15 +" as of 15% tax rate." 
    }
    else if(fsal>=1200000 && fsal<1500000){
        document.getElementById("output").innerHTML=fname+" has to pay Rs."+ fsal*0.20 +" as of 20% tax rate." 
    }
    else if(fsal>=1500000){
        document.getElementById("output").innerHTML=fname+" has to pay Rs."+ fsal*0.30 +" as of 30% tax rate." 
    }
}

