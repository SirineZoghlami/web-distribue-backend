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
public class Category implements Serializable {
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



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public Forum getForum() {
		return forum;
	}



	public void setForum(Forum forum) {
		this.forum = forum;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

	@OneToMany(mappedBy = "category")
	private List<Message> messages;

	@ManyToOne
	private Forum forum;
    
}
