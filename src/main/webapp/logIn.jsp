<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <jsp:include page="Header" />
    <!-- END nav -->

 

    <section class="ftco-section contact-section">
      <div class="container mt-5">
        <div class="row block-9">
   
		       <div class="col-md-5 ftco-animate">
            <form action="#" class="contact-form" method="POST">
            	
            		
	            <div class="form-group">
	                  <input type="text" class="form-control" placeholder="Nom"  name="nom">
	                </div>
               
	                <div class="form-group">
	                  <input type="text" class="form-control" placeholder="Prenom" name="prenom">
	                </div>
                <div class="form-group">
                <input type="number" class="form-control" placeholder="Tel" name="tel">
              </div>
               <div class="form-group">
                <input type="text" class="form-control" placeholder="Email" name="email">
              </div>
         
              <div class="form-group">
                <input type="password" class="form-control" placeholder="Mot De Passe" name="mot_de_passe">
              </div>

              <div class="form-group">
              
                <input type="submit" value="S'inscrir" class="btn btn-primary py-3 px-5" name="b_inscrir">
              </div>
            </form>
          </div>
					<div class="col-md-1"></div>
          <div class="col-md-5 ftco-animate">
            <form action="#" class="contact-form" method="POST">
 
               <div class="form-group">
                <input type="text" class="form-control" placeholder="Email" name="l_email">
              </div>
         
              <div class="form-group">
                <input type="password" class="form-control" placeholder="Mot De Passe" name="l_mot_de_passe">
              </div>
         
              
              
              <div class="form-group">
              
                <input type="submit" value="LogIn" class="btn btn-primary py-3 px-5" name="l_log_in">
              </div>
            </form>
          </div>
          
          
        </div>
      </div>
    </section>
    
 

   

<jsp:include page="Footer" />


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