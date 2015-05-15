package mr.controllers;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mr.dao.ArticleDao;
import mr.daoImp.ArticleDaoImp;
import mr.entities.Article;

@WebServlet("/nouvelarticle")
public class ServletNouvelArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("utilisateurConnecte") == null
				|| "".equals(request.getSession().getAttribute(
						"utilisateurConnecte"))) {

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
			view.forward(request, response);

		} else {

			if (request.getSession().getAttribute("rang")
					.equals("administrateur")) {

				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/ecrirearticle.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("/WEB-INF/accesinterdit.jsp");
				view.forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String contenu = request.getParameter("contenu");
		String titre = request.getParameter("titre");
		String mail = (String) request.getSession().getAttribute(
				"utilisateurConnecte");
		String page = request.getParameter("nompage");
		Boolean visiblePage = true;
		
		Boolean articleDescription = false;
		Article monArticle = new Article(contenu, titre, mail, page,
				visiblePage, articleDescription);
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		ArticleDao articleDao = new ArticleDaoImp();
		articleDao.ajouterArticle(monArticle, ipAddress);

		response.sendRedirect("maPageClassique?nompage=" + page);

	}

}
