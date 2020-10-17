

//getting the div elements where our search fields are stored
var searchTypeDiv = document.getElementById('searchTypeDiv');
var deptDiv = document.getElementById('deptDiv');
var advDiv  = document.getElementById('advDiv');

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


/* 
 * This funciton allows the styling for the custom dropdown select on the EnrollmentHome.jsp page
 * All of this code was taken from: https://www.w3schools.com/howto/howto_custom_select.asp
 */
window.addEventListener('load', function () {
    var x, i, j, l, ll, selElmnt, a, b, c;
    /* Look for any elements with the class "Selector": */
    x = document.getElementsByClassName("deptSelect");
    l = x.length;
    for (i = 0; i < l; i++) {
      selElmnt = x[i].getElementsByTagName("select")[0];
      ll = selElmnt.length;
      /* For each element, create a new DIV that will act as the selected item: */
      a = document.createElement("DIV");
      a.setAttribute("class", "select-selected");
      a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
      x[i].appendChild(a);
      /* For each element, create a new DIV that will contain the option list: */
      b = document.createElement("DIV");
      b.setAttribute("class", "select-items select-hide");
      for (j = 1; j < ll; j++) {
        /* For each option in the original select element,
        create a new DIV that will act as an option item: */
        c = document.createElement("DIV");
        c.innerHTML = selElmnt.options[j].innerHTML;
        c.addEventListener("click", function(e) {
            /* When an item is clicked, update the original select box,
            and the selected item: */
            var y, i, k, s, h, sl, yl;
            s = this.parentNode.parentNode.getElementsByTagName("select")[0];
            sl = s.length;
            h = this.parentNode.previousSibling;
            for (i = 0; i < sl; i++) {
              if (s.options[i].innerHTML == this.innerHTML) {
                s.selectedIndex = i;
                h.innerHTML = this.innerHTML;
                y = this.parentNode.getElementsByClassName("same-as-selected");
                yl = y.length;
                for (k = 0; k < yl; k++) {
                  y[k].removeAttribute("class");
                }
                this.setAttribute("class", "same-as-selected");
                break;
              }
            }
            h.click();
        });
        b.appendChild(c);
      }
      x[i].appendChild(b);
      a.addEventListener("click", function(e) {
        /* When the select box is clicked, close any other select boxes,
        and open/close the current select box: */
        e.stopPropagation();
        closeAllSelect(this);
        this.nextSibling.classList.toggle("select-hide");
        this.classList.toggle("select-arrow-active");
      });
    }

    function closeAllSelect(elmnt) {
      /* A function that will close all select boxes in the document,
      except the current select box: */
      var x, y, i, xl, yl, arrNo = [];
      x = document.getElementsByClassName("select-items");
      y = document.getElementsByClassName("select-selected");
      xl = x.length;
      yl = y.length;
      for (i = 0; i < yl; i++) {
        if (elmnt == y[i]) {
          arrNo.push(i)
        } else {
          y[i].classList.remove("select-arrow-active");
        }
      }
      for (i = 0; i < xl; i++) {
        if (arrNo.indexOf(i)) {
          x[i].classList.add("select-hide");
        }
      }
    }

    /* If the user clicks anywhere outside the select box,
    then close all select boxes: */
    document.addEventListener("click", closeAllSelect); 
});

//let deptDiv = document.getElementById("deptDiv");
//
//deptDiv.hidden=true;
//
//let showProgs = () => {
//    deptDiv.style.display = "block";
//};


