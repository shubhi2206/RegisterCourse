let login_form = document.getElementById('login-validation');
//$('#alertbox').hide();

login_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (login_form.checkValidity() === true) {
    let response = await fetch('api/authenticate', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({
          email: document.getElementById('email').value,
          password: document.getElementById('pass').value,
      })
    });
    let result = await response;
    if(result.status===200)
    {
      location.href = "CourseCreation.html";
    }
    else
    {
      //$('#alertbox').show();
      alert("Kindly enter correct credentials!");
    }
  }
  login_form.classList.add('was-validated');
});


