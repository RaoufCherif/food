<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Plat"%>
<%@page import="model.Panier"%>
<%@page import="model.Panier_boisson"%>
<%@page import="model.PanierDetails"%>
<%@page import="model.PanierDetails_boisson"%>
<%@page import="model.TypePlat"%> 
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

  	            
  
  
    
		
		<section class="ftco-section ftco-cart">
			<div class="container">
			      <center><h2>Panier</h2></center>	
			      <h2>Les Plats</h2>
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>Remove</th>
						        <th>Image</th>
						        <th>Product</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						      </tr>
						    </thead>
						    <tbody>
						    
						           <% Panier paniers=(Panier)session.getAttribute("panier");
            						for(PanierDetails pa:paniers.articles){ 
            						%>
						    
						      <tr class="text-center">
						        <td class="product-remove"><a href="Remove?id_del=<%=pa.getPlat().getId_plat()%>"><span class="icon-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(<%=pa.getPlat().getImage()%>);"></div></td>
						        
						        <td class="product-name">
						        	<h3><%=pa.getPlat().getNom_plat()%></h3>
						        	<p>Far far away, behind the word mountains, far from the countries</p>
						        </td>
						        
						       <td class="price"><%=pa.getPlat().getPrix()%></td>
						        
						        <td class="quantity">

						        	<div class="input-group mb-3">
					             	<input type="text" name="qte" class="quantity form-control input-number"   value="<%=pa.getQte()%>  " min="1" max="100">
					          	</div>

					          </td>
						        
						        <td class="total" id="tot">  <%= pa.getPlat().getPrix() * pa.getQte() %></td>
						      </tr>
						      
						      <% } %>
						      <!-- END TR-->

					    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		
    		
    		 <h2>Les Boisson</h2>
    					<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>Remove</th>
						        <th>Image</th>
						        <th>Product</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						      </tr>
						    </thead>
						    <tbody>
						    
						           <% Panier_boisson panierBoi=(Panier_boisson)session.getAttribute("panier_boisson");
            						for(PanierDetails_boisson pboi:panierBoi.articles){ 
            						%>
						    
						      <tr class="text-center">
						        <td class="product-remove"><a href="Remove?id_del=<%=pboi.getBoisson().getId_boisson()%>"><span class="icon-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(<%=pboi.getBoisson().getId_boisson() %>);"></div></td>
						        
						        <td class="product-name">
						        	<h3><%=pboi.getBoisson().getNom_boisson()%></h3>
						        	<p>Far far away, behind the word mountains, far from the countries</p>
						        </td>
						        
						       <td class="price"><%=pboi.getBoisson().getPrix()%></td>
						        
						        <td class="quantity">

						        	<div class="input-group mb-3">
					             	<input type="text" name="qte" class="quantity form-control input-number"   value="<%=pboi.getQte() %>  " min="1" max="100">
					          	</div>

					          </td>
						        
						        <td class="total" id="tot">  <%= pboi.getBoisson().getPrix() * pboi.getQte() %></td>
						      </tr>
						      
						      <% } %>
						      <!-- END TR-->

					    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		
    		
    		
    		
    		
    		
    		
    		<div class="row justify-content-end">
    			<div class="col col-lg-5 col-md-8 mt-7 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Cart Totals</h3>
    					<p class="d-flex">
    						<span>Total</span>
    						<span>${panier.total()+panier_boisson.total()}</span>
    					</p>
    					<p class="d-flex">
    						<span>Frais de livraison</span>
    						<span>0.00</span>
    					</p>
    					<p class="d-flex">
    						<span>Promo</span>
    						<span>0.00</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>Montant à régler</span>
    						<span>${panier.total()+panier_boisson.total()}</span>
    					</p>
    				</div>
    				<label>Date de livraison
    							<input type="text" name="date" id="date" class="quantity form-control input-number" placeholder="yyyy-mm-dd" >
    					</label>		  
    							<%   if( paniers.articles.size() == 0 && panierBoi.articles.size() == 0) { %> 
	         		         
	          		
    		             			<p class="text-center"><a href="Menu" class="btn btn-danger py-3 px-4">Remplir Votre Panier</a></p>
	          	
	          	   <%} else if((boolean)session.getAttribute("isConnected") == false ) { %>
	      
    				<p class="text-center"><a href="Login_redirect" class="btn btn-primary py-3 px-4">Inscription / LogIn</a></p>
    				
    				
	          <%} else { %>
	      
    			<p class="text-center"><a id="zak" onclick= "dateLivraison()" class="btn btn-primary py-3 px-4">Procéder au payement</a></p>

				


	             	<%} %>		
	          	
    			</div>
    		</div>
			</div>
		</section>
		
		<script>
		
		function dateLivraison(){
			var date =document.getElementById("date").value;
			alert("Vous avez saisi : "+ date);
			document.getElementById("zak").setAttribute("href", "Checkout?valider=ok&date_livraison="+date );
			
			}
		
	

		</script>
		
		

    <section class="ftco-section">
    	<div class="container">
    		<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate text-center">
          	<span class="subheading">Discover</span>
            <h2 class="mb-4">Related products</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
          </div>
        </div>
        <div class="row">
        	<div class="col-md-3">
        		<div class="menu-entry">
    					<a href="#" class="img" style="background-image: url(images/menu-1.jpg);"></a>
    					<div class="text text-center pt-4">
    						<h3><a href="#">Coffee Capuccino</a></h3>
    						<p>A small river named Duden flows by their place and supplies</p>
    						<p class="price"><span>$5.90</span></p>
    						<p><a href="#" class="btn btn-primary btn-outline-primary">Add to Cart</a></p>
    					</div>
    				</div>
        	</div>
        	<div class="col-md-3">
        		<div class="menu-entry">
    					<a href="#" class="img" style="background-image: url(images/menu-2.jpg);"></a>
    					<div class="text text-center pt-4">
    						<h3><a href="#">Coffee Capuccino</a></h3>
    						<p>A small river named Duden flows by their place and supplies</p>
    						<p class="price"><span>$5.90</span></p>
    						<p><a href="#" class="btn btn-primary btn-outline-primary">Add to Cart</a></p>
    					</div>
    				</div>
        	</div>
        	<div class="col-md-3">
        		<div class="menu-entry">
    					<a href="#" class="img" style="background-image: url(images/menu-3.jpg);"></a>
    					<div class="text text-center pt-4">
    						<h3><a href="#">Coffee Capuccino</a></h3>
    						<p>A small river named Duden flows by their place and supplies</p>
    						<p class="price"><span>$5.90</span></p>
    						<p><a href="#" class="btn btn-primary btn-outline-primary">Add to Cart</a></p>
    					</div>
    				</div>
        	</div>
        	<div class="col-md-3">
        		<div class="menu-entry">
    					<a href="#" class="img" style="background-image: url(images/menu-4.jpg);"></a>
    					<div class="text text-center pt-4">
    						<h3><a href="#">Coffee Capuccino</a></h3>
    						<p>A small river named Duden flows by their place and supplies</p>
    						<p class="price"><span>$5.90</span></p>
    						<p><a href="#" class="btn btn-primary btn-outline-primary">Add to Cart</a></p>
    					</div>
    				</div>
        	</div>
        </div>
    	</div>
    </section>

   
     <!-- Start footer -->
     <jsp:include page="Footer"/>
  
    <!-- End footer -->

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



    
  </body>
</html>