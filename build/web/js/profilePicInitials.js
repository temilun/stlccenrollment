/* 
    author: tom
    
    
    Adds initials of student to avatar
 */



window.addEventListener('load', function () {
    let stuName = document.getElementById("studentName").textContent.split(" ");
    let initials = stuName[0].charAt(0) + stuName[1].charAt(0);

    document.getElementById("profileImage").innerHTML = initials;
});

