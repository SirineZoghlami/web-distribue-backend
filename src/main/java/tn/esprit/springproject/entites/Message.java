package tn.esprit.springproject.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public Date getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	public Utilisateur getAuteur() {
		return auteur;
	}


	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}


	public Utilisateur getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	private String contenu;
	private Date datePublication;

	@ManyToOne
	@JoinColumn(name = "auteur_id")
	private Utilisateur auteur;

	@ManyToOne
	@JoinColumn(name = "destinataire_id")
	private Utilisateur destinataire;

	@ManyToOne
	private Forum forum;

	@ManyToOne
	private Category category;
}
