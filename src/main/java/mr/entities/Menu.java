package mr.entities;


public class Menu {
	private int idpage;
	private String nompage;
	private int rang;
	/*private Boolean visibilite;*/
	
	public Menu(int idpage, String nompage, int rang/*, Boolean visibilite*/) {
		super();
		this.idpage = idpage;
		this.nompage = nompage;
		this.rang = rang;
		/*this.visibilite = visibilite;*/
	}

	public int getIdpage() {
		return idpage;
	}

	public String getNompage() {
		return nompage;
	}

	public int getRang() {
		return rang;
	}

	

	/*public Boolean getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Boolean visibilite) {
		this.visibilite = visibilite;
	}*/

		
}
