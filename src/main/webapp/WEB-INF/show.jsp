<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>It Works!!</title>
</head>
<body>
    <h1>${book.getTitle()}</h1>
    <p>Description: ${book.getDescription()}</p>
    <p>Language: ${book.getLanguage()}</p>
    <p>Number of Pages: ${book.getNumberOfPages()}</p>
</body>
</html>