package com.graction.lumi.model.location;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleLocationModel {
	private ArrayList<GoogleLocationItem> results;
	private String status;

	public ArrayList<GoogleLocationItem> getResults() {
		return results;
	}

	public void setResults(ArrayList<GoogleLocationItem> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("GoogleLocationModel [results=[");
		for (GoogleLocationItem item : results)
			builder.append(item.toString() + ",");
		builder.append("], status=" + status + "]");
		return builder.toString();
	}

	public class GoogleLocationItem {
		private ArrayList<ItemComponent> address_components;
		private Geometry geometry;
		private String formatted_address;

		public ArrayList<ItemComponent> getAddress_components() {
			return address_components;
		}

		public void setAddress_components(ArrayList<ItemComponent> address_components) {
			this.address_components = address_components;
		}

		public String getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder("GoogleLocationItem [address_components=[");
			for (ItemComponent component : address_components)
				builder.append(component.toString() + ",");
			builder.append("], formatted_address=" + formatted_address + "]");
			builder.append(", geometry=" + geometry);
			return builder.toString();
		}

		public class ItemComponent {
			private String long_name, short_name;
			private String[] types;

			public String getLong_name() {
				return long_name;
			}

			public void setLong_name(String long_name) {
				this.long_name = long_name;
			}

			public String getShort_name() {
				return short_name;
			}

			public void setShort_name(String short_name) {
				this.short_name = short_name;
			}

			public String[] getTypes() {
				return types;
			}

			public void setTypes(String[] types) {
				this.types = types;
			}

			@Override
			public String toString() {
				return "ItemComponent [long_name=" + long_name + ", short_name=" + short_name + ", types="
						+ Arrays.toString(types) + "]";
			}

		}

		public class Geometry {
			private Location location;
			private String place_id;
			private String[] types;

			public Location getLocation() {
				return location;
			}

			public void setLocation(Location location) {
				this.location = location;
			}

			public String getPlace_id() {
				return place_id;
			}

			public void setPlace_id(String place_id) {
				this.place_id = place_id;
			}

			public String[] getTypes() {
				return types;
			}

			public void setTypes(String[] types) {
				this.types = types;
			}

			@Override
			public String toString() {
				return "Geometry [location=" + location + ", place_id=" + place_id + ", types=" + Arrays.toString(types)
						+ "]";
			}

			public class Location {
				private String lat, lng;

				public String getLat() {
					return lat;
				}

				public void setLat(String lat) {
					this.lat = lat;
				}

				public String getLng() {
					return lng;
				}

				public void setLng(String lng) {
					this.lng = lng;
				}

				@Override
				public String toString() {
					return "Location [lat=" + lat + ", lng=" + lng + "]";
				}

			}

			public class Viewport {
				private Location northeast, southwest;

				public Location getNortheast() {
					return northeast;
				}

				public void setNortheast(Location northeast) {
					this.northeast = northeast;
				}

				public Location getSouthwest() {
					return southwest;
				}

				public void setSouthwest(Location southwest) {
					this.southwest = southwest;
				}

				@Override
				public String toString() {
					return "Viewport [northeast=" + northeast + ", southwest=" + southwest + "]";
				}

			}
		}
	}
}
