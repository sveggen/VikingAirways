function checkforMatchingPasswords(form) {
    var pass1 = form.newpassword.value;
    var pass2 = form.newpassword2.value;
    if (pass1.value != pass2.value) {
       return false;
    } else {
        alert("Passwords Match");
        return true;
    }
}