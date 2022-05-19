let url = "http://localhost:8080/HibernateRefactor/"

let showHomesBtn = document.getElementById("showHomesBtn");
showHomesBtn.addEventListener("click", showHomes);

let showAddHome = document.getElementById("showAddHomeDivBtn");
showAddHome.addEventListener("click", showaddHome);

let addHomeBtn = document.getElementById("addHomeBtn");
addHomeBtn.addEventListener("click", addHome);

let showAvengersBtn = document.getElementById("showAvengersBtn");
showAvengersBtn.addEventListener("click", showAvengers);

let showAddAvengerBtn = document.getElementById("showAddAvengerBtn");
showAddAvengerBtn.addEventListener("click", showAddAvenger);


//Display functions
function showHomes() {
  let homesTable = document.getElementById("HomesTableDiv");
  HideAllFuncs();
  if (homesTable.style.display === "none") {
    homesTable.style.display = "block";
    fetchHomes();
    console.log("fetching homes");
  } else {
    homesTable.style.display = "none";
  }
}

function showaddHome() {
  let addHomeForm = document.getElementById("AddHomeDiv");
  HideAllFuncs();
  if (addHomeForm.style.display === "none") {
    addHomeForm.style.display = "block";
  } else {
    addHomeForm.style.display = "none";
  }
}

function showAvengers() {
  let AvengersTableDiv = document.getElementById("AvengersTableDiv");
  HideAllFuncs();
  if (AvengersTableDiv.style.display === "none") {
    AvengersTableDiv.style.display = "block";
    fetchAvengers();
    console.log("fetching avengers");
  } else {
    AvengersTableDiv.style.display = "none";
  }
}

function showAddAvenger() {
  let AddAvengerDiv = document.getElementById("AddAvengerDiv");
  HideAllFuncs();
  if (AddAvengerDiv.style.display === "none") {
    AddAvengerDiv.style.display = "block";
  } else {
    AddAvengerDiv.style.display = "none";
  }
}

//Homes functions

async function fetchHomes(){

  let response = await fetch(url+"home");

  if(response.status === 200){ //request successful
    let data = await response.json();
    populateHomes(data);
  }else{
    console.log("Could not find the homes.")
  }

}

function populateHomes(homes){
  let tbody = document.getElementById("homeBody");
  tbody.innerHTML = "";

  for(let home of homes){
    let row = document.createElement('tr');
    for(let cell in home){
      let td = document.createElement('td');
      td.innerText = home[cell];
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}


async function addHome(){
  let home = gatherHome();

  let response = await fetch(url+"home",
    {
      method: "POST",
      body: JSON.stringify(home)
    })
  if(response.status ===201){
    console.log("Home added successfully.")
  }else{
    console.log("Something went wrong adding the home")
    console.log(response)
  }
}

function gatherHome(){
  let newName = document.getElementById("homeName").value;
  let newNum = document.getElementById("stNum").value;
  let newStr = document.getElementById("stName").value;
  let newCity = document.getElementById("city").value;
  let newRegion = document.getElementById("region").value;
  let newPostCode = document.getElementById("postCode").value;
  let newCountry = document.getElementById("country").value;

  let home = {
    homeName: newName,
    addrStreetNum: newNum,
    addrStreetName: newStr,
    addrCity: newCity,
    addrRegion: newRegion,
    addrPostCode: newPostCode,
    addrCountry: newCountry
  }

  return home;
}

//Avenger functions

async function fetchAvengers(){
  let response = await fetch(url + "avenger");

  if (response.status === 200) { //request successful
    let data = await response.json();
    populateAvengers(data);
  } else {
    console.log("Could not find the avengers.")
  }
}

function populateAvengers(avengers) {
  let tbody = document.getElementById("avengerTableBody");
  tbody.innerHTML = "";

  for (let avenger of avengers) {
    let row = document.createElement('tr');
    for (let cell in avenger) {
      let td = document.createElement('td');
      td.innerText = avenger[cell];
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}

async function addAvenger(){
  let avenger = gatherAvenger();

  let response = await fetch(url + "avenger",
    {
      method: "POST",
      body: JSON.stringify(avenger)
    })
  if (response.status === 201) {
    console.log("Avenger added successfully.")
  } else {
    console.log("Something went wrong adding the avenger")
    console.log(response)
  }
}

function gatherAvenger() {
  let newHeroName = document.getElementById("newHeroName").value;
  let newPower = document.getElementById("newPower").value;
  let newFirstName = document.getElementById("newFirstName").value;
  let newLastName = document.getElementById("newLastName").value;
  let newPowerLevel = document.getElementById("newPowerLevel").value;
  //let newHome = document.getElementById("newHome").value;

  let avenger = {
    heroName: newHeroName,
    power: newPower,
    fName: newFirstName,
    lName: newLastName,
    powerLevel: newPowerLevel,
    //home: newHome
  }

  return avenger;
}



function HideAllFuncs() {
  /*
  let usersTable = document.getElementById("usersTable");
  usersTable.style.display = "none";
  let mticketsTable = document.getElementById("managerTicketsTable");
  mticketsTable.style.display = "none";
  let processReimb = document.getElementById("processReimb");
  processReimb.style.display = "none";
  let uticketsTable = document.getElementById("userTicketsTable");
  uticketsTable.style.display = "none";
  let ncreateTicket = document.getElementById("createTicket");
  ncreateTicket.style.display = "none";
  */
}
