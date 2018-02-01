package exercise;

import java.util.Objects;

public class PriceUpdate {

	private final String companyName;
	private final double price;

	public PriceUpdate(String companyName, double price) {
		this.companyName = companyName;
		this.price = price;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return companyName + " - " + price;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		PriceUpdate that = (PriceUpdate) obj;

		return Objects.equals(this.companyName, that.companyName) && 
				Objects.equals(this.price, that.price);

	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName, price);
	}

}
