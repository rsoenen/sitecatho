package mr.dao;

import java.util.List;

import mr.entities.Image;

public interface ImageDao {
	public void ajouterImage(Image addimage,String ipPosteur);
	public List<Image> listeImageCategorie(int idCategorie);
}
