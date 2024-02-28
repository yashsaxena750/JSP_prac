<!DOCTYPE html>
<html lang="en">

<head>

    <title>XSS</title>

</head>


<body>
<h2>Fill Form</h2>

<form action=<%= request.getContextPath()%>/formsubmit-servlet method="post">

    <label>
        Name:
        <input type="text" name="name">
    </label><br>

    <label>
        Gender:
        <input type="radio" value="Male" name="gndr">Male
        <input type="radio" value="Female" name="gndr">Female
    </label><br>

    <label>
        Languages:
        <input type="checkbox" value="Hindi" name="lang">Hindi
        <input type="checkbox" value="Kannada" name="lang">Kannada
        <input type="checkbox" value="English" name="lang">English
    </label><br>

    <label>
        Country:
        <select name="cnt">
            <option value="India">India</option>
            <option value="US">US</option>
            <option value="Dubai">Dubai</option>
        </select>
    </label><br>

    <label>
        <input type="submit" value="submit">
    </label>

</form>

</body>
</html>
