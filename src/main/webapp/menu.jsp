<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@page import="model.Client"%> 
 <%@page import="model.Boisson"%> 
 <%@page import="model.TypePlat"%> 
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
    
    <jsp:include page="Header" />
    <!-- END nav -->

    <section class="home-slider owl-carousel">

      <div class="slider-item" style="background-image: url(images/restaurant_menu_gold.png);" data-stellar-background-ratio="0.5">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center">

            <div class="col-md-7 col-sm-12 text-center ftco-animate">
            	<h1 class="mb-3 mt-5 bread">Our Menu</h1>
	            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Menu</span></p>
            </div>

          </div>
        </div>
      </div>
    </section>


    <section class="ftco-section">
    	<div class="container">
        <div class="row">
        	<div class="col-md-6 mb-5 pb-3">
        	
        	
        		<h3 class="mb-5 heading-pricing ftco-animate">Starter</h3>
        		    <% ArrayList<Plat> plats = new ArrayList<Plat>();
		                plats = (ArrayList)request.getAttribute("collplatEnt");
		                for(Plat plat:plats){
		              %>
        		
        		<div class="pricing-entry d-flex ftco-animate">
        			<a href="Single_plat?id_plat=<%=plat.getId_plat()  %>" ><div class="img" style="background-image: url(<%= plat.getImage() %>);"></div></a>
        			<div class="desc pl-3">
	        			<div class="d-flex text align-items-center">
	        				<h3><span><a href="Single_plat?id_plat=<%=plat.getId_plat()  %>" ><%= plat.getNom_plat() %></a></span></h3>
	        				<span class="price"><%=plat.getPrix() %>€</span>
	        			</div>
	        			<div class="d-block">
	        				<p>A small river named Duden flows by their place and supplies</p>
	        			</div>
        			</div>
        		</div>
        		
        	<%} %>
        	
        	</div>

        	<div class="col-md-6 mb-5 pb-3">
        		<h3 class="mb-5 heading-pricing ftco-animate">Main Dish</h3>
        		
        		     <% ArrayList<Plat> platMain = new ArrayList<Plat>();
		                platMain = (ArrayList)request.getAttribute("collplatMain");
		                for(Plat plat:platMain){
		              %>
        		<div class="pricing-entry d-flex ftco-animate">
        			<a href="Single_plat?id_plat=<%=plat.getId_plat()  %>" ><div class="img" style="background-image: url(<%= plat.getImage() %>);"></div></a>
        			<div class="desc pl-3">
	        			<div class="d-flex text align-items-center">
	        				<h3><span><%= plat.getNom_plat() %></span></h3>
	        				<span class="price"><%=plat.getPrix() %>€</span>
	        			</div>
	        			<div class="d-block">
	        				<p>A small river named Duden flows by their place and supplies</p>
	        			</div>
	        		</div>
        		</div>
        		
        		
        		<%} %>
        		
        
        	
        	</div>
        	
        	

        	<div class="col-md-6">
        		<h3 class="mb-5 heading-pricing ftco-animate">Desserts</h3>
        		     <% ArrayList<Plat> platDes = new ArrayList<Plat>();
		                platDes = (ArrayList)request.getAttribute("collplatDes");
		                for(Plat plat:platDes){
		              %>
        		<div class="pricing-entry d-flex ftco-animate">
        			<a href="Single_plat?id_plat=<%=plat.getId_plat()  %>" ><div class="img" style="background-image: url(<%= plat.getImage() %>);"></div></a>
        			<div class="desc pl-3">
	        			<div class="d-flex text align-items-center">
	        				<h3><span><%= plat.getNom_plat() %></span></h3>
	        				<span class="price"><%=plat.getPrix() %>€</span>
	        			</div>
	        			<div class="d-block">
	        				<p>A small river named Duden flows by their place and supplies</p>
	        			</div>
	        		</div>
        		</div>
        		
        		<%} %>
        	</div>

        	<div class="col-md-6">
        		<h3 class="mb-5 heading-pricing ftco-animate">Drinks</h3>
        		
        		
        		     <% ArrayList<Boisson> boi = new ArrayList<Boisson>();
		               boi = (ArrayList)request.getAttribute("colBoi");
		                for(Boisson b:boi){
		              %>
        		<div class="pricing-entry d-flex ftco-animate">
        			<a href="Single_boisson?id_boisson=<%=b.getId_boisson()%>" ><div class="img" style="background-image: url(<%=b.getImage() %>);"></div></a>
        			
        			<div class="desc pl-3">
	        			<div class="d-flex text align-items-center">
	        				<h3><span><a href="Single_boisson?id_boisson=<%=b.getId_boisson()%>" ><%=b.getNom_boisson() %></span></h3>
	        				<span class="price"><%=b.getPrix() %>€</span>
	        			</div>
	        			<div class="d-block">
	        				<p>A small river named Duden flows by their place and supplies</p>
	        			</div>
	        		</div>
        		</div>
        		
        		<%} %>
        	
        	
        	</div>
        </div>
    	</div>
    </section>

    
		<section class="ftco-menu">
    	<div class="container">
    		<div class="row justify-content-center mb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">Discover</span>
            <h2 class="mb-4">Our Products</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
          </div>
        </div>
    		<div class="row d-md-flex">
	    		<div class="col-lg-12 ftco-animate p-md-5">
		    		<div class="row">
		          <div class="col-md-12 nav-link-wrap mb-5">
		            <div class="nav ftco-animate nav-pills justify-content-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
		              <a class="nav-link active" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Entrées</a>

		              <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Plats principal</a>

		              <a class="nav-link" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Desserts</a>
		            </div>
		          </div>
		          <div class="col-md-12 d-flex align-items-center">
		            
		            <div class="tab-content ftco-animate" id="v-pills-tabContent">
		            
		            

		              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="v-pills-1-tab">
		              	<div class="row">
		              <% ArrayList<Plat> collplatEnt = new ArrayList<Plat>();
		              collplatEnt = (ArrayList)request.getAttribute("collplatEnt");
		                for(Plat plat:collplatEnt){

		              %>
		             
		              		<div class="col-md-4 text-center">
		              			<div class="menu-wrap">
		              				<a href="#" class="menu-img img mb-4" style="background-image: url(<%=plat.getImage() %>);"></a>
		              				<div class="text">
		              					<h3><a href="#"><%=plat.getNom_plat() %></a></h3>
		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
		              					<p class="price"><span><%=plat.getPrix() %> EURO</span></p>
		              					<p><a href="Single_plat?id_plat=<%=plat.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Commander</a></p>
		              					<p><a href="Detail_plat?id_plat=<%=plat.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Voir plus de details</a></p>
		              				</div>
		              			</div>
		              		</div>
		              		
		              		<%} %>
		              	</div>
		              </div>

		              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-2-tab">
		                <div class="row">
		              
		              	      <% ArrayList<Plat> platM = new ArrayList<Plat>();
		                platM = (ArrayList)request.getAttribute("collplatMain");
		                for(Plat pl:platM){

		              %>
		              		<div class="col-md-4 text-center">
		              			<div class="menu-wrap">
		              				<a href="#" class="menu-img img mb-4" style="background-image: url(<%=pl.getImage() %>);"></a>
		              				<div class="text">
		              					<h3><a href="#"><%=pl.getNom_plat() %></a></h3>
		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
		              					<p class="price"><span><%=pl.getPrix() %> EURO</span></p>
		              					<p><a href="Single_plat?id_plat=<%=pl.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Commander</a></p>
		              					<p><a href="Detail_plat?id_plat=<%=pl.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Voir plus de details</a></p>
		              				</div>
		              			</div>
		              		</div>
		              		
		              		<%} %>
		              	</div>
		              </div>

		              <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-3-tab">
		                <div class="row">
		                    	      <% ArrayList<Plat> platD = new ArrayList<Plat>();
		                platD = (ArrayList)request.getAttribute("collplatDes");
		                for(Plat p:platD){

		              %>
		                
		              	
		              		<div class="col-md-4 text-center">
		              			<div class="menu-wrap">
		              				<a href="#" class="menu-img img mb-4" style="background-image: url(<%=p.getImage() %>);"></a>
		              				<div class="text">
		              					<h3><a href="#"><%=p.getNom_plat() %></a></h3>
		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
		              					<p class="price"><span><%=p.getPrix() %> EURO</span></p>
		              					<p><a href="Single_plat?id_plat=<%=p.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Commnder</a></p>
		              					<p><a href="Detail_plat?id_plat=<%=p.getId_plat()  %>" class="btn btn-primary btn-outline-primary">Voir plus de details</a></p>
		              				</div>
		              			</div>
		              		</div>
		              		
		              		
		              		<%} %>
		              	</div>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
    	</div>
    </section>
    
	    <!-- Start footer -->
	    <jsp:include page="Footer" />
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