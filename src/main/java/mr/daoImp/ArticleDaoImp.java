package mr.daoImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mr.dao.ArticleDao;
import mr.entities.Article;

public class ArticleDaoImp implements ArticleDao{
	
	public List<Article> listeArticlePage(String nomPage){
		Connection connection;
		List<Article> listeArticle= new ArrayList<Article>();
		try {
			connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt= connection.prepareStatement("SELECT * FROM `article` WHERE `page`=? ORDER BY `dateCreation` DESC ");
			stmt.setString(1, nomPage); 
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Article article= new Article(results.getString("contenu"),results.getString("mailAuteur"));
				listeArticle.add(article);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeArticle;
		
	}
}