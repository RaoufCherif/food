<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Client"%>
<%@page import="model.TypePlat"%> 
<%@page import="java.util.ArrayList"%> 

  	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="Index">Your<small>Food</small></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item "><a href="Index" class="nav-link">Accueil</a></li>
	          <li class="nav-item"><a href="Menu" class="nav-link">Menu</a></li>
	         
	   
           <% if((boolean)session.getAttribute("isConnected") == false) { %> 
	          <li class="nav-item"><a href="LogIn" class="nav-link">Inscription / LogIn</a></li>
	          <%} else{ %>
	          
	           <li class="nav-item"><a href="blog.html" class="nav-link">${nom}</a></li>
	              
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="room.html" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Panier</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="shop.html">Voir panier</a>
                <a class="dropdown-item" href="product-single.html">Total</a>
                <a class="dropdown-item" href="checkout.html">Accéder au payement</a>
              </div>
            </li>
	           <li class="nav-item"><a href="Deconnexion" class="nav-link">Deconnexion</a></li>
	    
	          
	           
	           
	          <%} %>
	          <li class="nav-item cart"><a href="Panier" class="nav-link"><span class="icon icon-shopping_cart"></span><span class="bag d-flex justify-content-center align-items-center"><small>  ${panier.count()+panier_boisson.count() } </small></span></a></li>
	        </ul>
	      </div>
		  </div>
	  </nav>