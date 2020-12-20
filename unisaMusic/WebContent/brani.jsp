<%@page import="java.util.ArrayList"%>
<%@page import="modelbean.UserBean"%>
<%@page import="modelbean.BranoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	UserBean user = (UserBean) session.getAttribute("user"); 
    ArrayList<BranoBean> brani = (ArrayList<BranoBean>) request.getAttribute("brani");
    System.out.println(brani.size());
    %>
    
	
<jsp:include page="/header.jsp" >
<jsp:param value="Brani" name="title"/>
	</jsp:include>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<!-- song -->
			<div class="song-item">
				<div class="row">
					<div class="col-lg-4">
						<div class="song-info-box">
							<img src="img/songs/1.jpg" alt="">
							<div class="song-info">
								<h4>Jennifer Brown</h4>
								<p>One Night in Ibiza</p>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="single_player_container">
							<div class="single_player">
								<div class="jp-jplayer jplayer" data-ancestor=".jp_container_1" data-url="music-files/1.mp3"></div>
								<div class="jp-audio jp_container_1" role="application" aria-label="media player">
									<div class="jp-gui jp-interface">

										<!-- Player Controls -->
										<div class="player_controls_box">
											<button class="jp-prev player_button" tabindex="0"></button>
											<button class="jp-play player_button" tabindex="0"></button>
											<button class="jp-next player_button" tabindex="0"></button>
											<button class="jp-stop player_button" tabindex="0"></button>
										</div>
										<!-- Progress Bar -->
										<div class="player_bars">
											<div class="jp-progress">
												<div class="jp-seek-bar">
													<div>
														<div class="jp-play-bar"><div class="jp-current-time" role="timer" aria-label="time">0:00</div></div>
													</div>
												</div>
											</div>
											<div class="jp-duration ml-auto" role="timer" aria-label="duration">00:00</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
	
	

		<ol>
 		<%for(BranoBean b: brani) {%>
 		<li>Titolo: <%=b.getTitle() %> </li>
 		<li>Nome Artista: <%=b.getNomeArtista() %>
 		<!-- 
 		<a href="AggiungiCarrello?id=<%=b.getID()%>"> Aggiungi al Carrello </a>
 		 -->
 		<!-- Player Controls -->
										<div class="player_controls_box">
											<button class="jp-prev player_button" tabindex="0"></button>
											<button class="jp-play player_button" tabindex="0"></button>
											<button class="jp-next player_button" tabindex="0"></button>
											<button class="jp-stop player_button" tabindex="0"></button>
										</div>
					<div class="col-lg-4">
						<div class="songs-links">
							<img src="img/icons/p-1.png" alt="" class="stellabianca">
							<img src="img/icons/star_86960.png" alt="" class=stellacolorata>
						<!--  	<a href=""><img src="img/icons/p-2.png" alt=""></a> -->
							<a href="AggiungiCarrello?id=<%=b.getID()%>"><img src="img/icons/p-3.png" alt=""></a>
						</div>
					</div>
										<!-- Progress Bar -->
										<div class="player_bars">
											<div class="jp-progress">
												<div class="jp-seek-bar">
													<div>
														<div class="jp-play-bar"><div class="jp-current-time" role="timer" aria-label="time"><%=b.getTime() %></div></div>
													</div>
												</div>
											</div>
											<div class="jp-duration ml-auto" role="timer" aria-label="duration">00:00</div>
										</div>
									</div>
									<div class="jp-no-solution">
										
									</div>
								</div>
							</div>
						</div>
					</div>
					
 		<!-- 
 		<button onclick="AggiungiCarrello?id=<%=b.getID()%>"> Aggiungi al carrello</button>
 		 -->
 		</li>
 		<%} %>
		</ol>


		<jsp:include page="/footer.jsp" />
		
		<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/main.js"></script>

	<!-- Audio Player and Initialization -->
	<script src="js/jquery.jplayer.min.js"></script>
	<script src="js/jplayerInit.js"></script>

	<script>
$(document).ready(function(){
	$(".stellacolorata").hide();
  $(".stellabianca").click(function(){
    $(this).hide();
    $(this).next().show();
  });
  $(".stellacolorata").click(function(){
	    $(this).hide();
	    $(this).prev().show();
  });
});
</script>

</body>
</html>