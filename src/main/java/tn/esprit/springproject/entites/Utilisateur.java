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
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Message> getMessagesEnvoyes() {
		return messagesEnvoyes;
	}



	public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
		this.messagesEnvoyes = messagesEnvoyes;
	}



	public Forum getForum() {
		return forum;
	}



	public void setForum(Forum forum) {
		this.forum = forum;
	}



	private String nom;
    private String email;

    @OneToMany(mappedBy = "auteur")
    private List<Message> messagesEnvoyes;
   

    
    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;
}
