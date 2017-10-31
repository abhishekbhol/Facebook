<%@page import="javax.swing.table.TableModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="sx" uri="/struts-dojo-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events</title>
<link rel="shortcut icon" href="http://teamtreehouse.com/assets/favicon.ico">
  <link rel="icon" href="http://teamtreehouse.com/assets/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="/Facebook/asset/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap-responsive.min.css">
  <link rel="stylesheet" type="text/css" media="all" href="css/global.css">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" language="javascript" charset="utf-8" src="/Facebook/asset/js/bootstrap.min.js"></script>
  
  <sx:head />
</head>
<body>
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
          Create Event
        </button>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  style="width:50%">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header" style="background-color: #6d84b4;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Create Event</h4>
              </div>
              <div class="modal-body">
					<s:form name="createEvent" action="#">
						<table cellspacing=10 >
							<tr>
								<td>Name </td>
								<td><input type="text" value="" placeholder="Ex. Birthday Party"/>
								</td>
							</tr>
							
							<tr>
								<td>Details 
								</td>
								<td><textarea rows="3" cols="50" placeholder="Add more info." ></textarea></td>
							</tr>
							<tr>
								<td>Where
								</td>
								<td><input type="text" value="" placeholder="Add a place." /></td>
							</tr>
							<tr>
								<td>When
								</td>
								<td><sx:datetimepicker name="whenDate"
										displayFormat="dd-MMM-yyyy" value="" />
								<input type="text" value=""  placeholder="Add a time."/></td>
							</tr>
						</table>

					</s:form>
				</div>
                
              </div>
              <div class="modal-footer">
                 <button type="button" class="btn btn-primary">Save</button>
                 <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
             </div>
            
            </div>
          </div>
        </div>

</body>
</html>