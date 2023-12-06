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
public class Forum implements Serializable {
    public long getIdFourm() {
		return idFourm;
	}
	public void setIdFourm(long idFourm) {
		this.idFourm = idFourm;
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFourm;
   

    
    @OneToMany(mappedBy = "forum")
    private List<Utilisateur> utilisateurs;
    @OneToMany(mappedBy = "forum")
    private List<Message> messages;
    @OneToMany(mappedBy = "forum")
    private List<Category> categories;
}
