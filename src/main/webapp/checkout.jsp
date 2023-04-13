<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@page import="model.Client"%> 
  <%@page import="model.Panier"%>
   <%@page import="model.Panier_boisson"%>
   <%@page import="model.PanierDetails_boisson"%>
   <%@page import="model.Boisson"%>
 <%@page import="model.TypePlat"%> 
 <%@page import="model.PanierDetails"%>
  <%@page import="model.Plat"%> 
 <%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Coffee - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Great+Vibes" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
   <!-- START nav -->
   
   <jsp:include page="Header"/>
 
    <!-- END nav -->

 
						    
						    
    <section class="ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-xl-8 ftco-animate">
		<h3 class="billing-heading mb-4"> Plats </h3>
        <table id="example" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                                <th>plat</th>
                                                <th>Prix</th>
                                                <th>Qte</th>
                                                <th>total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% Panier paniers=(Panier)session.getAttribute("panier");
            						for(PanierDetails pa:paniers.articles){ 
            						%>
                                            <tr>
                                            	<td><%=pa.getPlat().getNom_plat() %></td>
                                            	    <td><%=pa.getPlat().getPrix() %></td>
                                                <td><%=pa.getQte()  %></td>
                                                 <td><%= pa.getQte() *  pa.getPlat().getPrix() %></td>
                                            </tr>
                                    <% } %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                             <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>${panier.total()} EURO</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    
           </div> <!-- .col-md-8 -->
                  <div class="col-xl-8 ftco-animate">
		<h3 class="billing-heading mb-4"> boisson </h3>
        <table id="example" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                                <th>boisson</th>
                                                <th>Prix</th>
                                                <th>Qte</th>
                                                <th>total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% Panier_boisson panier_boisson=(Panier_boisson)session.getAttribute("panier_boisson");
            						for(PanierDetails_boisson boi:panier_boisson.articles){ 
            						%>
                                            <tr>
                                            	<td><%=boi.getBoisson().getNom_boisson() %></td>
                                            	    <td><%=boi.getBoisson().getPrix() %></td>
                                                <td><%=boi.getQte()  %></td>
                                                 <td><%= boi.getQte() *  boi.getBoisson().getPrix() %></td>
                                            </tr>
                                    <% } %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                             <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>${panier_boisson.total()} EURO</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    
           </div> <!-- .col-md-8 -->
           
                  <div class="col-xl-8 ftco-animate">
		<h3 class="billing-heading mb-4"> Total </h3>
        <table id="example" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th>Qte Produits</th>
                                                <th>total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                 
                                            <tr>
                                            	<th></th>
                                                <th></th>
                                            	 <td> ${panier.count()+ panier_boisson.count()}</td>
                                                <td> ${panier.total()+ panier_boisson.total()} </td>
                                             
                                            </tr>
                                   
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                            	 <th></th>
                                                <th></th>
                                                <th> ${panier.count()+ panier_boisson.count()}</th>
                                                <th>${panier.total()+ panier_boisson.total()}EURO</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    
           </div> <!-- .col-md-8 -->
	          	<div class="col-xl-4 ftco-animate">
	          		<div class="cart-detail ftco-bg-dark p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">Payment Method</h3>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Direct Bank Tranfer</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Check Payment</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Paypal</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="checkbox">
											   <label><input type="checkbox" value="" class="mr-2"> I have read and accept the terms and conditions</label>
											</div>
										</div>
									</div>
									<% String date_livraison= (String)request.getAttribute("date_livraison"); %>
									<p><a href="Valider_commande?payement=payer&date_livraison=<%= date_livraison %>"class="btn btn-primary py-3 px-4">Payer</a></p>
								</div>
								
								
	          	</div>
	          
         
        </div>
      </div>
    </section> <!-- .section -->

 <!-- footer -->
  <jsp:include page="Footer"/>
 <!-- end footer -->
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>

  <script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
	</script>

    
  </body>
</html>