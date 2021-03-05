let rowIndex;
window.onload = init_fxn;
function init_fxn(){
    document.getElementById("div2").hidden=true;
    fetch_specialization();
    fetch_domain();
    fetch_prerequisite();
}

function validate1(val) {
    v1 = document.getElementById("name");
    v2 = document.getElementById("description");
    v3 = document.getElementById("year");
    v4 = document.getElementById("term");
    v5 = document.getElementById("capacity");
    v6 = document.getElementById("credit");
    v7 = document.getElementById("faculty");

    flag1 = true;
    flag2 = true;
    flag3 = true;
    flag4 = true;
    flag5 = true;
    flag6 = true;
    flag7 = true;

    if(val>=1 || val==0) {
        if(v1.value == "") {
            v1.style.borderColor = "red";
            flag1 = false;
        }
        else {
            v1.style.borderColor = "green";
            flag1 = true;
        }
    }

    if(val>=2 || val==0) {
        if(v2.value == "") {
            v2.style.borderColor = "red";
            flag2 = false;
        }
        else {
            v2.style.borderColor = "green";
            flag2 = true;
        }
    }

    if(val>=3 || val==0) {
        if(v3.value == "") {
            v3.style.borderColor = "red";
            flag3 = false;
        }
        else {
            v3.style.borderColor = "green";
            flag3 = true;
        }
    }

    if(val>=4 || val==0) {
        if(v4.value == "") {
            v4.style.borderColor = "red";
            flag4 = false;
        }
        else {
            v4.style.borderColor = "green";
            flag4 = true;
        }
    }
    if(val>=5 || val==0) {
        if(v5.value == "") {
            v5.style.borderColor = "red";
            flag5 = false;
        }
        else {
            v5.style.borderColor = "green";
            flag5 = true;
        }
    }
    if(val>=6 || val==0) {
        if(v6.value == "") {
            v6.style.borderColor = "red";
            flag6 = false;
        }
        else {
            v6.style.borderColor = "green";
            flag6 = true;
        }
    }
    if(val>=7 || val==0) {
        if(v7.value == "") {
            v7.style.borderColor = "red";
            flag7 = false;
        }
        else {
            v7.style.borderColor = "green";
            flag7 = true;
        }
    }

    flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7;

    return flag;
}

function validate2(val) {
   let var1 = document.getElementById("room");
   let var2 = document.getElementById("building");
   let var3 = document.getElementById("time1");

    let f1 = true;
    let f2 = true;
    let f3 = true;

    if(val>=1 || val==0) {
        if(var1.value == "") {
            var1.style.borderColor = "red";
            f1 = false;
        }
        else {
            var1.style.borderColor = "green";
            f1 = true;
        }
    }

    if(val>=2 || val==0) {
        if(var2.value == "") {
            var2.style.borderColor = "red";
            f2 = false;
        }
        else {
            var2.style.borderColor = "green";
            f2 = true;
        }
    }
    if(val>=3 || val==0) {
        if(var3.value == "") {
            var3.style.borderColor = "red";
            f3 = false;
        }
        else {
            var3.style.borderColor = "green";
            f3 = true;
        }
    }

    let flag = f1 && f2 && f3;

    return flag;
}

$(document).ready(function(){


    var current_fs, next_fs, previous_fs;

    var steps = $(".card-body").length;
    console.log(steps);
    var current = 1;
    setProgressBar(current);

    $(".next").click(function(){

        str1 = "next1";
        str2 = "next2";
        str3 = "next3";

        if(!str2.localeCompare($(this).attr('id')) && validate1(0) == true) {
            val2 = true;
        }
        else {
            val2 = false;
        }

        if(!str3.localeCompare($(this).attr('id')) && validate2(0) == true) {
            val3 = true;
        }
        else {
            val3 = false;
        }

        if((!str1.localeCompare($(this).attr('id'))) || (!str2.localeCompare($(this).attr('id')) && val2 == true) || (!str3.localeCompare($(this).attr('id')) && val3 == true)) {
            current_fs = $(this).parent().parent();
            next_fs = $(this).parent().parent().next();

            $(current_fs).removeClass("show");
            $(next_fs).addClass("show");

            current_fs.animate({}, {
                step: function() {

                    current_fs.css({
                        'display': 'none',
                        'position': 'relative'
                    });

                    next_fs.css({
                        'display': 'block'
                    });
                }
            });
            setProgressBar(++current);
            var c = document.getElementById('cnt').textContent;
            document.getElementById('cnt').textContent = Number(c) + 25;
        }
    });

    $(".prev").click(function(){

        current_fs = $(this).parent().parent();
        previous_fs = $(this).parent().parent().prev();

        $(current_fs).removeClass("show");
        $(previous_fs).addClass("show");

        current_fs.animate({}, {
            step: function() {

                current_fs.css({
                    'display': 'none',
                    'position': 'relative'
                });

                previous_fs.css({
                    'display': 'block'
                });
            }
        });
        setProgressBar(--current);
        var c = document.getElementById('cnt').textContent;
        document.getElementById('cnt').textContent = Number(c) - 25;
    });

    function setProgressBar(curStep){
        var percent = parseFloat(100 / steps) * curStep;
        percent = percent.toFixed();
        $(".progress-bar").css("width",percent+"%");
    }

    $('.radio-group .radio').click(function(){
        //console.log(this.id);
        if (this.id === "r1" || this.id=== "r3")
        {
            $(this).addClass('disabled');

        }
        else {
            $('.selected .fa').removeClass('fa-check');
            $('.selected .fa').addClass('fa-circle');
            $('.radio').removeClass('selected');
            $(this).addClass('selected');
            $('.selected .fa').removeClass('fa-circle');
            $('.selected .fa').addClass('fa-check');
        }

    });
    //Adding table jquery
    // Denotes total number of rows
    let rowIdx = 0;

    // jQuery button click event to add a row
    $('#addBtn').on('click', function () {

        // Adding a row inside the tbody.
        $('#tbody').append(`<tr id="R${++rowIdx}"> 
             <td class="row-index text-center"> 
             <input type="time" class="form-control" id="time${rowIdx}" placeholder=""> 
             </td> 
              <td class="text-center"> 
                <select id="day${rowIdx}" class="form-control">
                                <option >Monday</option>
                                <option>Tuesday</option>
                                <option>Wednesday</option>
                                <option>Thursday</option>
                                <option>Friday</option>
                                <option>Saturday</option>
                </select>
                </td> 
              </tr>`);
        rowIndex = rowIdx;
    });


});
document.getElementById("logout").addEventListener("click", function() {
    location.href="index.html";
});
document.getElementById("add_new_course").addEventListener("click", function() {
    location.href="CourseCreation.html";
});
async function fetch_specialization()
{
    let response = await fetch("api/specialization/get");
   // console.log(response);
    let specializations = await response.json(); // read response body and parse as JSON
   // console.log(specializations);
    let specialization_option = document.getElementById('specialization');
    //specialization_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i< specializations.length ; i++){
        specialization_option.innerHTML += '<option value="'+specializations[i]+'">'+specializations[i]+'</option>';
    }
}
async function fetch_domain()
{
    let response = await fetch("api/domain/get");
    //console.log(response);
    let domains = await response.json(); // read response body and parse as JSON
   // console.log(domains);
    let domain_option = document.getElementById('domain');


    for(let i = 0 ; i< domains.length ; i++){
        domain_option.innerHTML += '<option value="'+domains[i]+'">'+domains[i]+'</option>';
    }
}
async function fetch_prerequisite()
{
    let response = await fetch("api/courses/get");
    //console.log(response);

    let pre = await response.json(); // read response body and parse as JSON
    //console.log(pre);
    let pre_option = document.getElementById('prerequisites');


    for(let i = 0 ; i< pre.length ; i++){
        pre_option.innerHTML += '<option value="'+pre[i]+'">'+pre[i]+'</option>';
    }
}


document.getElementById("submit_button").addEventListener("click", function() {

    let checked_dom = document.querySelectorAll('#domain :checked');
    let selected_domain = [...checked_dom].map(option => option.value);

    let checked_pre = document.querySelectorAll('#prerequisites :checked');
    let selected_pre = [...checked_pre].map(option => option.value);

    let course_details = {
        course_name : document.getElementById("name").value,
        course_description : document.getElementById("description").value,
        year: document.getElementById("year").value,
        term :document.getElementById("term").value,
        capacity :document.getElementById("capacity").value,
        credit : document.getElementById("credit").value,
        faculty :document.getElementById("faculty").value,
    }
    let specialization_name = document.getElementById("specialization").value;

    let i;
    let scheduleList =[];
    // console.log(rowIndex);
    for(i=0;i<rowIndex;i++)
    {
         scheduleList.push({
                 time : document.getElementById('time'+(i+1)).value,
                 day : document.getElementById('day'+(i+1)).value,
                 room : document.getElementById("room").value,
                 building : document.getElementById("building").value,
             }

         );

    }

    $.ajax(
        {
            url:"api/courses/post",
            type:"POST",
            contentType:"application/json",
            data: JSON.stringify({course:course_details,specialization:specialization_name,domains:selected_domain,scheduleList:scheduleList,prerequisites:selected_pre}),
            statusCode:{
                200:function()
                {
                   // alert("hii");
                    document.getElementById("div1").hidden=true;
                    document.getElementById("div2").hidden=false;
                    document.getElementById("heading").textContent="Course has been registered. Click on 'Add another Course' to create a new course..";

                },
                204: function ()
                {
                    //alert("Be");
                    document.getElementById("heading").textContent="Course has already been registered. Click on 'Add another Course' to create a new course..";
                    document.getElementById("div1").hidden=true;
                    document.getElementById("div2").hidden=false;
                }
            }

        });

});