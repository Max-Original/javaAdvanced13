package hw.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "basket")
public class Basket {

	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserAccount user;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private Product product;
	
	@Column(name = "date_purchase")
	private Date date_purchase;
	
	public Basket() {}

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate_purchase() {
		return date_purchase;
	}

	public void setDate_purchase(Date date_purchase) {
		this.date_purchase = date_purchase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_purchase == null) ? 0 : date_purchase.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (date_purchase == null) {
			if (other.date_purchase != null)
				return false;
		} else if (!date_purchase.equals(other.date_purchase))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", user=" + user + ", product=" + product + ", date_purchase=" + date_purchase
				+ "]";
	}
	
	
}
