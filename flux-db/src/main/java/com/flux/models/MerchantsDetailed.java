package com.flux.models;

import java.util.UUID;

public class MerchantsDetailed {

	private UUID id;
	private String name;
	private String locationName;

	MerchantsDetailed() {
	}

	public MerchantsDetailed(UUID id, String name, String locationName) {
		super();
		this.id = id;
		this.name = name;
		this.locationName = locationName;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MerchantsDetailed other = (MerchantsDetailed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerchantsDetailed [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", locationName=");
		builder.append(locationName);
		builder.append("]");
		return builder.toString();
	}

}
