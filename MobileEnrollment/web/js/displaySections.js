/* 
 * author: tom
 * Description: JS functions for the displaysections webpage will be kept here
 */


//selects row's radio button by clicking row. if button is already selected,
//the row will be unchecked and isRadioChecked() is ran to see if any other buttons
//are selected. if none are selected, the add to cart button is disabled
let checked;

let selectRow = (crn) => {
    row = document.getElementById(crn);
    if (row.checked === false) {
        row.checked = true;
        enableBtn();
    } else {
        row.checked = false;
        if (isRadioChecked() === false) {
            disableBtn();
        }
    };
};


//checks all inputs to see if any radio buttons are checked
let isRadioChecked = () => {
    let radios = document.getElementsByTagName('input');
    for (let i = 0; i < radios.length; i++) {
        if (radios[i].type === 'radio' && radios[i].checked) {
            return true;
        }
    }
    return false;
};

let enableBtn = () => {
    document.getElementById('disabledBtn').id = 'searchBtn';
};

let disableBtn = () => {
    document.getElementById('searchBtn').id = 'disabledBtn';
};

