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
	

		<ol>
 		<%for(BranoBean b: brani) {%>
 		<li>Titolo: <%=b.getTitle() %> </li>
 		<li>Nome Artista: <%=b.getNomeArtista() %>
 		
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
</body>
</html>