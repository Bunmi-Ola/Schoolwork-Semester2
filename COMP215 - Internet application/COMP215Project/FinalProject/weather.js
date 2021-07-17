src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js";


var radioChecked = 0;

$(document).ready(function () {

    var mainElement = document.getElementById('weatherPage');
    loadContacts(); // load and display any weather search logs in storage

    $("div#City").show(); //show the city div onload
    $("div#Postal").hide(); //hide the postal div onload
    $("div#Latitude").hide();//hide the Latitude div onload
    document.getElementById("CityRadio").checked = true; //always check city radio button on load
   //using the radio button checked to determine the label and input to be displayed
    $('input[type="radio"]').click(function () {
        radioChecked = $(this).val();
        $("div.myDiv").hide();
        $("#" + radioChecked).show();

    });

    // Add invalid event directly to input element
    var CityName = document.getElementById("CityNameTextbox");
    var CityCountryCode = document.getElementById("CityCountryCodeTextbox");
    var PostalCode = document.getElementById("PostalCodeTextbox");
    var PostalCountryCode = document.getElementById("PostalCountryCodeTextbox");
    var LatitudeCode = document.getElementById("LatitudeTextbox");
    var LongetudeCode = document.getElementById("LongetudeTextbox");

    //put all inputboxes in an array
    var elements = $("input[name=inputTextbox]");

    for (var i = 0; i < elements.length; i++) {
      
        elements[i].oninput = function (event) { // check valid state, and force raise oninvalid if needed
            inputTextbox = event.target;//Global variable
            inputTextbox.checkValidity(); // clear out the validity message
        };

        elements[i].oninvalid = function (event) {
            inputTextbox = event.target;//Global variable
            inputTextbox.setCustomValidity(""); // clear out the validity message

            //if (!CityName.validity.valid || !CityCountryCode.validity.valid || !PostalCode.validity.valid...) {
            if (!inputTextbox.validity.valid) {// if any validation constraint fails


                if (inputTextbox == CityName) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity(" City Name is missing ");
                    }
                }

                if (inputTextbox == CityCountryCode) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.patternMismatch) {
                        inputTextbox.setCustomValidity(" You entered a wrong value type (Enter a 2 uppercase country code eg CA)");
                    } if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity("Value is missing, please enter the country code")
                    }
                }

                if (inputTextbox == PostalCode) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity(" Postal code Value is missing ");
                    }
                    if (inputTextbox.validity.patternMismatch) {
                        inputTextbox.setCustomValidity("Wrong value type entered (eg A1A)")
                    }
                }

                if (inputTextbox == PostalCountryCode) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.patternMismatch) {
                        inputTextbox.setCustomValidity(" You entered a wrong value type (Enter a 2 uppercase country code eg CA)");
                    } if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity("Value is missing, please enter the country code")
                    }
                }

                if (inputTextbox == LatitudeCode) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.rangeOverflow) {
                        inputTextbox.setCustomValidity(" Value too large, max allowed is 90 characters");
                    }
                    if (inputTextbox.validity.rangeUnderflow) {
                        inputTextbox.setCustomValidity(" Value too small, min accepted is -90 characters ");
                    }
                    if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity(" Latitude Value is missing ");
                    }
                    if (inputTextbox.validity.typeMismatch) {
                        inputTextbox.setCustomValidity(" Value is should be a number (type mismatch)");

                    }
                }

                if (inputTextbox == LongetudeCode) { //compare global variable with each textbox
                    inputTextbox.setCustomValidity("");
                    if (inputTextbox.validity.rangeOverflow) {
                        inputTextbox.setCustomValidity(" Value too large, max allowed is 90 characters");
                    }
                    if (inputTextbox.validity.rangeUnderflow) {
                        inputTextbox.setCustomValidity(" Value too small, min accepted is -90 characters ");
                    }
                    if (inputTextbox.validity.typeMismatch) {
                        inputTextbox.setCustomValidity(" Value is should be a number (type mismatch)");

                    }
                    if (inputTextbox.validity.valueMissing) {
                        inputTextbox.setCustomValidity(" Longetude Value is missing ");
                    }

                }


            }

        };

    }

   
    // putting answer in the button click event
    $("#SearchButton").click(

        function (evt) {
            //evt.preventDefault();
            //check for input textbox that are visbible and confirm the input are valid before search
            $('#WeatherSearchForm :input:visible[required="required"]').each(function validateForm() {
                if (!this.checkValidity()) {
                    event.preventDefault();// stop the submit from posting (default behavior)
            
                 
                return false;
                }

            
            });  
            
            //if ($(evt.target).parents('form')[0].checkValidity()) {     // continue only if all form field are valid 
                    // compose and send request
                    var CityName = $("#CityNameTextbox").val();
                    var CityCountryCode = $("#CityCountryCodeTextbox").val();
                    var PostalCode = $("#PostalCodeTextbox").val();
                    var PostalCountryCode = $("#PostalCountryCodeTextbox").val();
                    var LatitudeCode = $("#LatitudeTextbox").val();
                    var LongetudeCode = $("#LongetudeTextbox").val();

                    var apiKey = "";

                    var selectedRadio = $("input:radio[name=searchBy]:checked").val()

                    var SearchString = 0;
                    
                    if (selectedRadio == "City") {
                        SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                            "?q=" + CityName + "," + CityCountryCode +
                            "&APPID=" + apiKey;
                    }

                    if (selectedRadio == "Postal") {
                        SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                            "?q=" + PostalCode + "," + PostalCountryCode +
                            "&APPID=" + apiKey;
                    }

                    if (selectedRadio == "Latitude") {
                        SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                            "?lat=" + LatitudeCode + "&lon=" + LongetudeCode +
                            "&APPID=" + apiKey;
                    }


                    //Creating an XMLHttpRequest object
                    var xhttp = new XMLHttpRequest();
                    // open a connection to a URL 
                    xhttp.open("GET", SearchString, true);
                    //send request
                     xhttp.send();

                    // implement an event handler that is called when the XMLHttpRequest object
                    // has received a response (or an error)
                    xhttp.onreadystatechange = function () {
                        
                           // process respsonse from the server
                        if (this.readyState == 4 && this.status == 200) {

                            var SearchResponse = this.responseText;

                             // convert to javascript object
                            var log = JSON.parse(SearchResponse);

                            //object by properties
                            var city_name = log["name"]; // log.name
                            var country_name = log["sys"]["country"]; //log.sys.country                    
                            var Longitude = log["coord"]["lon"];
                            var Latitude = log["coord"]["lat"];
                            var weather_description = log["weather"][0]["description"];
                            // log.weather[0].description <- the 1st element of the weather array's description property
                            var Temperature = ((log["main"]["temp"] - 273.15).toFixed(2));// temp in K, subtract: C = K −273.15
                            var pressure = log["main"]["pressure"];
                            var Humidity = log["main"]["humidity"];
                            var wind_speed = log["wind"]["speed"];
                            var wind_Direction = log["wind"]["deg"];
                            var Sunrise = (new Date(log["sys"]["sunrise"] * 1000)).toLocaleTimeString(); //To get current local time
                            var Sunset = (new Date(log["sys"]["sunset"] * 1000)).toLocaleTimeString(); //To get current local time


                            $("#city_name").html("City: " + city_name);
                            $("#country_name").html("Country: " + country_name);
                            $("#weather_description").html("Weather: " + weather_description);

                            //getting weather infomation base on checkbox checked
                            if ($('#Longitudecheckbox').is(":checked")) {

                                $("#Longitude").html("Longitude: " + Longitude);
                            }
                            else {
                                $("#Longitude").html("");
                            }



                            if ($('#Latitudecheckbox').is(":checked")) {
                                $("P#Latitude").html("Latitude: " + Latitude);
                            }
                            else {
                                $("P#Latitude").html("");
                            }


                            if ($('#Temperaturecheckbox').is(":checked")) {
                                $("#Temperature").html("Temperature: " + Temperature);
                            }
                            else {
                                $("#Temperature").html("");
                            }


                            if ($('#Pressurecheckbox').is(":checked")) {
                                $("#pressure").html("Pressure: " + pressure);
                            }
                            else {
                                $("#pressure").html("");
                            }


                            if ($('#Humiditycheckbox').is(":checked")) {
                                $("#Humidity").html("Humidity: " + Humidity);
                            }
                            else {
                                $("#Humidity").html("");
                            }


                            if ($('#WindSpeedcheckbox').is(":checked")) {
                                $("#wind_speed").html("Wind Speed: " + wind_speed);
                            }
                            else {
                                $("#wind_speed").html("");
                            }


                            if ($('#WindDirectioncheckbox').is(":checked")) {
                                $("#wind_Direction").html("wind Direction: " + wind_Direction);
                            }
                            else {
                                $("#wind_Direction").html("");
                            }


                            if ($('#Sunrisecheckbox').is(":checked")) {
                                $("#Sunrise").html("Sunrise: " + Sunrise);
                            }
                            else {
                                $("#Sunrise").html("");
                            }


                            if ($('#Sunsetcheckbox').is(":checked")) {
                                $("#Sunset").html("Sunset: " + Sunset);
                            }
                            else {
                                $("#Sunset").html("");

                            }
                            saveContact(log);// save the form data 
                        };

                    }
                            
         });
     
    //clear local storage when the clear log button is clicked
    $("#ClearLog").button().click(function (evt) {
        evt.preventDefault();
        localStorage.clear(); //deleting all weater search logs in local storage
        $(mainElement).find('table#WeatherLogTable tbody').remove(); // clearing the weather log table
    });

    //delect a row when the row delete button is cliked
    $(mainElement).on("click", "a.delete",
        function (evt) {
            evt.preventDefault();
            deleteLogs(evt);
        });
    
    //load function to display all search weather logs in the local storage
    function loadContacts() {

        var LogsStored = localStorage.getItem('logs');
        if (LogsStored) { // check if we have any data
            logs = JSON.parse(LogsStored); // convert data into an array of objects
            $.each(logs, function (index, log) {

                   // show object by properties
                var city_name = log["name"]; // obj.name
                var country_name = log["sys"]["country"]; //obj.sys.country
                var Longitude = log["coord"]["lon"];
                var Latitude = log["coord"]["lat"];
                var Temperature = ((log["main"]["temp"] - 273.15).toFixed(2));// temp in K, subtract: C = K −273.15
                var pressure = log["main"]["pressure"];
                var Humidity = log["main"]["humidity"];
                var wind_speed = log["wind"]["speed"];
                var wind_Direction = log["wind"]["deg"];
                var Sunrise = (new Date(log["sys"]["sunrise"] * 1000)).toLocaleTimeString();
                var Sunset = (new Date(log["sys"]["sunset"] * 1000)).toLocaleTimeString();
                var weather_description = log["weather"][0]["description"];

                var row = $('<tr>'); // create an empty row object
                var logInfo = '<td>' + city_name + '</td>' +
                    '<td>' + country_name + '</td>' +                    
                    '<td>' + Longitude + '</td>' +
                    '<td>' + Latitude + '</td>' +
                    '<td>' + weather_description + '</td>' +
                    '<td>' + Temperature + '</td>' +
                    '<td>' + pressure + '</td>' +
                    '<td>' + Humidity + '</td>' +
                    '<td>' + wind_speed + '</td>' +
                    '<td>' + wind_Direction + '</td>' +
                    '<td>' + Sunrise + '</td>' +
                    '<td>' + Sunset + '</td>' +
                    '<td><a class="delete" href="#">delete</a></td>';

                //<tr contactID=""> addind a custom HTML attribute to the row, with a value of the ID
                row.data().LogId = log.id;

                row.append(logInfo); // attach html of td's to blank row
                $(mainElement).find('table#WeatherLogTable tbody').append(row);
            });
        }
    }


    function store(log) {
        // get string data for the whole array from storage
        var LogsStored = localStorage.getItem('logs');
        var logs = []; // create empty array
        if (LogsStored) { // if we have any data in storage
            logs = JSON.parse(LogsStored); // load contacts array with that data
        }
        logs.push(log); // add new contact (push) to end of array
        // overwrite any existing 'contacts' key with new stringified array
        localStorage.setItem('logs', JSON.stringify(logs));
    }

    function saveContact(log) {

        log.id = $.now();// use clock as a unique key

        var city_name = log["name"]; // obj.name
        var country_name = log["sys"]["country"]; //obj.sys.country
        var Longitude = log["coord"]["lon"];
        var Latitude = log["coord"]["lat"];
        var Temperature = ((log["main"]["temp"] - 273.15).toFixed(2));// temp in K, subtract: C = K −273.15
        var pressure = log["main"]["pressure"];
        var Humidity = log["main"]["humidity"];
        var wind_speed = log["wind"]["speed"];
        var wind_Direction = log["wind"]["deg"];
        var Sunrise = (new Date(log["sys"]["sunrise"] * 1000)).toLocaleTimeString();
        var Sunset = (new Date(log["sys"]["sunset"] * 1000)).toLocaleTimeString();
        var weather_description = log["weather"][0]["description"];

    var mainElement = document.getElementById('weatherPage');
    
    //adding a new row to the weather logs table
    var row = $('<tr>');
    var tableResultsHTML = '<td>' + city_name + '</td>' +
        '<td>' + country_name + '</td>' +       
        '<td>' + Longitude + '</td>' +
        '<td>' + Latitude + '</td>' +
        '<td>' + weather_description + '</td>' +
        '<td>' + Temperature + '</td>' +
        '<td>' + pressure + '</td>' +
        '<td>' + Humidity + '</td>' +
        '<td>' + wind_speed + '</td>' +
        '<td>' + wind_Direction + '</td>' +
        '<td>' + Sunrise + '</td>' +
        '<td>' + Sunset + '</td>' +
        '<td><a class="delete" href="#">delete</a></td>';

    row.data().LogId = log.id; //assigning a log ID to the new row
    row.append(tableResultsHTML);

    store(log); // save record in local storage

     $(mainElement).find('table#WeatherLogTable tbody').append(row);          

    }


    function deleteLogs(evt) {
       
        // get the ID from the parent row of the selected link
        var LogId = $(evt.target).parents('tr').data().LogId;
        // get current data as a array from local storage
        var logs = JSON.parse(localStorage.getItem('logs'));

        // use JQuery to filter out the contacts with required ID to delete
        // for each element in contacts array, run function
        // if true, keep the element in selection, otherwise not
        // effectly deletes the item with id = ContactID
        var newLogs = logs.filter(function (c) {
            return c.id != LogId;
        });
        // overwrite storage with new array
        localStorage.setItem('logs', JSON.stringify(newLogs));

        // remove the parent row of the selected link
        $(evt.target).parents('tr').remove();
    }

  
});

