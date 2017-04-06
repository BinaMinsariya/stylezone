 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp" %>
<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<center><h2 style="color:#D35A40;">Sign Up</h2></center>
						<br>
						<form:form method="post" modelAttribute="userDetails">
							<div class="form-group">
								<label for="username">User Name</label>
								<form:input path="username" class="form-control" />
								<form:errors path="username"></form:errors>
							</div>
							<div class="form-group">
								<label for="emailid">Email</label>
								<form:input path="emailid" class="form-control" />
								<form:errors path="emailid"></form:errors>
							</div>
							<div class="form-group">
								<label for="emailid">Mobile</label>
								<form:input path="mobileno" class="form-control" />
								<form:errors path="mobileno"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:password path="password" class="form-control" />
								<form:errors path="password"></form:errors>
							</div>
							<div class="form-group">

								<form:hidden path="role" value="CUSTOMER" hidden='true'
									class="form-control" />
							</div>
							<div class="form-group">

								<form:hidden path="is_active" value="true" hidden="true"
									class="form-control" />
							</div>
							<center><input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input
								type="submit" name="_eventId_cancel" value="CANCEL"
								class="btn btn-danger" /></center>


						</form:form>



					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>
	
	<%@include file="footer.jsp"%>
