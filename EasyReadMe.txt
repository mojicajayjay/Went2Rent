Spring MVC Readme for noobs (thats me):

I. Creating a JSP file

If you want to link your JSP forms to a servlet, always put the action as your URL string (found in the Controller class).

Example:  <form class = "regform" action="register" method="POST" onsubmit = "return validateRegistration()">

II. Edit the Controller file

Look for went2rent.Servlet.wen2rentController.java. Add in your URL pattern in the Class URL. After doing so, add that in the urlPatters list on the lower part. Add the appropriate action handler for that URL link.

III. Edit the ActionHandler

Create the appropriate ActionHandler. In this case RegisterActionHandler and make an override method called execute with parameters HttpServletRequest request, HttpServletResponse response. Make sure the Class implements ActionHandler.

Instantiate variables in this class by utilizing the request.getparameter() method. For example, when utilizing a Register, use the RegisterActionHandler to create a new instance of a String username and doing this:

String username = request.getParameter("username");

then use this to call the appropriate Service class.

IV. Service Classes

Following the assignment of values in the ActionHandler, create a Service class. Following the previous example, create a UserService.java class in the went2rent.service package. Add appropriate methods such as addUser in the case of Register. It is of best interest to make it a boolean method so that we can call it in the if statements. Going back to the RegisterActionHandler class, we can then add:

if(addUser(username)){
	request.getRequestDispatcher("index.jsp").forward(request, response);