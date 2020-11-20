

//getting the div elements where our search fields are stored
const searchTypeDiv = document.getElementById('searchTypeDiv');
const deptDiv = document.getElementById('deptDiv');
const advDiv  = document.getElementById('advDiv');


//functions to show/hide the search fields

let showSearchTypeDiv = () => {
    searchTypeDiv.style.display = 'block';
};

let showAdvSearch = () => {
    deptDiv.style.display = 'none';
    advDiv.style.display = 'block';
};


let showProgs = () => {
    advDiv.style.display = 'none';
    deptDiv.style.display = 'block';
};

//Enabling button only after a department is selected


//function to enable the "search for classes" button, only after
//a radio button has been selected - uses html id's and css to change
//button styling

let enableBtn = () => {
    document.getElementById('disabledBtn').id = 'searchBtn';
};

