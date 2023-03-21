

const status = document.getElementById("job-offer-status");
if(status.innerText === "OPEN"){
    status.style.backgroundColor = "green";
}
else{
    status.style.backgroundColor = "red";
}
