package Grazioso;

public class monkey extends RescueAnimal {
	private String species;
	private String tailLength;
	private String bodyLength;
	private String height;
	
	//add monkey specific parameters
	public monkey(String name, String species, String gender, String age,
		    String weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry, String tailLength,
			String bodyLength, String height) {
				setName(name);
		        setSpecies(species);
		        setGender(gender);
		        setAge(age);
		        setWeight(weight);
		        setAcquisitionDate(acquisitionDate);
		        setAcquisitionLocation(acquisitionCountry);
		        setTrainingStatus(trainingStatus);
		        setReserved(reserved);
		        setInServiceCountry(inServiceCountry);
		        setTailLength(tailLength);
		        setBodyLength(bodyLength);
		        setHeight(height);

		    }

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
	/**
	 * @return the tailLength
	 */
	public String getTailLength() {
		return tailLength;
	}

	/**
	 * @param tailLength the tailLength to set
	 */
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}

	/**
	 * @return the bodyLength
	 */
	public String getBodyLength() {
		return bodyLength;
	}

	/**
	 * @param bodyLength the bodyLength to set
	 */
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
}
