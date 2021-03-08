<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<title>Cart</title>
</head>


<body>

<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
				<tbody>
					<c:forEach items="${liste}" var="prod">
						<tr>
					
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="../images/${prod.getImage()}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${prod.getName()}</h4>
										<p> ${prod.getName()} ${prod.getCategorie()}  Core i5-4308U Dual-Core 2.8GHz 8GB 512GB SSD 13.3</p>
									</div>
								</div>
							</td>
							<td data-th="Price" id="prix">${prod. getPrice()} $</td>
							<td data-th="Quantity">
								<input id="qte" type="number" class="form-control text-center" min="1" value="${prod.getQuantite()}">
							</td>
							<td data-th="Subtotal" class="text-center" id="tot" >${prod. getPrice()} $ </td>
							
							<td class="actions" data-th="">
								<form action="/cart/dell/${prod.getIdProduit()}"> 
									<button   type="submit" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
								</form>								
							</td>
						</tr>
					
					
					</c:forEach>
				
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						<tr>
							<td><a href="Continue" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong></strong></td>
							
							
							<td><a href="checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
				
</div>

</body>
</html>