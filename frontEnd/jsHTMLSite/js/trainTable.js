var trainCars = []; 
var trainHeaders; 

function setup()
{
    checkSignedIn(); 
    trainHeaders = document.querySelectorAll("#trainTable th");
    createTrain();
    populateTable();
    for(var header of trainHeaders)
    {
        header.addEventListener("click", sortTrain);
    }//end for
}//end setup


function Train(railroad, modelName, type, year, scale, number)
{
    this.railroad = railroad;
    this.modelName = modelName;
    this.type = type;
    this.year = year;
    this.scale = scale;
    this.number = number;
}//end Train()

function populateTable(){
    console.log("populating table");
    var output = "";
    for(var car of trainCars)
    {
        output = output + "<tr>";
        //console.log(car);
        for(var v of Object.keys(car))
        {
            output = output + "<td>" + car[v] + "</td>";
        }
    }
    document.querySelector("#tableContent").innerHTML = output; 
}//end populateTable

function createTrain()
{
    var railways = ["Canadian National", "Amtrak", "BNSF", "Canadian Pacific", "CSX", "Kansas City Southern", "Norfolk Southern", "Union Pacific"];
    var typesOfCars = ["Box Car", "Passenger", "Gondola", "Engine", "Dining Car"];
    var carModelTypes = ["BC", "P", "G", "E", "DC"];
    var scales = ["HO", "O", "N"];

    console.log("making train");
    for(var i = 0; i < 20; i++)
    {
        var carType = Math.floor(Math.random() * typesOfCars.length)
        var car = new Train();
        car.railroad = railways[Math.floor(Math.random() * railways.length)]; 
        car.type = typesOfCars[carType]; 
        car.scale = scales[Math.floor(Math.random() * scales.length)]; 
        car.modelName = carModelTypes[carType] + "-" + Math.floor((Math.random() * 10000) + 10000); 
        car.number = Math.floor((Math.random() * 1000) + 1000);
        car.year = Math.floor((Math.random() * 217) + 1804);
        trainCars.push(car);
    }//end for
}//end createTrain


function sortTrain()
{
    console.log(trainCars);
    console.log("sort trains");
    var sortFunction; 
    var sortType = this.innerHTML;
    console.log(sortType);
    if(sortType == "Railroad")
    {
        sortFunction = new function(a, b)
        {
            console.log(a);
            console.log(b);
            return a.railroad.compareTo(b.railroad);
        }
    }//end if
    else if(sortType == "Model Name")
    {

    }//end if model name
    else if(sortType == "Type")
    {

    }//end if type
    else if(sortType == "Year")
    {

    }//end if year
    else if(sortType == "Scale")
    {

    }//end if scale
    else if(sortType == "Car Number")
    {

    }//end if car number

    trainCars.sort(sortFunction); 
    populateTable(); 
}//end sortTrain
