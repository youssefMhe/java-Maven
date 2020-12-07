package projet.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)


	public class ResourcesEntity {
	        private String distanceUnit;
	        private String trafficDataUsed;
	        private String __type;
	        private List<Double> bbox;
	        private Integer travelDuration;
	        private String trafficCongestion;
	        private Double travelDistance;
	        private String id;
	        private String durationUnit;
	        private Integer travelDurationTraffic;
	        private String travelMode;

	        public void setDistanceUnit(String distanceUnit) {
	            this.distanceUnit = distanceUnit;
	        }


	        public void setTrafficDataUsed(String trafficDataUsed) {
	            this.trafficDataUsed = trafficDataUsed;
	        }

	        public void set__type(String __type) {
	            this.__type = __type;
	        }

	        public void setBbox(List<Double> bbox) {
	            this.bbox = bbox;
	        }

	        public void setTravelDuration(Integer travelDuration) {
	            this.travelDuration = travelDuration;
	        }

	        public void setTrafficCongestion(String trafficCongestion) {
	            this.trafficCongestion = trafficCongestion;
	        }

	        public void setTravelDistance(Double travelDistance) {
	            this.travelDistance = travelDistance;
	        }

	        public void setId(String id) {
	            this.id = id;
	        }

	        public void setDurationUnit(String durationUnit) {
	            this.durationUnit = durationUnit;
	        }

	        public void setTravelDurationTraffic(Integer travelDurationTraffic) {
	            this.travelDurationTraffic = travelDurationTraffic;
	        }

	        public void setTravelMode(String travelMode) {
	            this.travelMode = travelMode;
	        }

	        public String getDistanceUnit() {
	            return distanceUnit;
	        }

	        public String getTrafficDataUsed() {
	            return trafficDataUsed;
	        }

	        public String get__type() {
	            return __type;
	        }

	        public List<Double> getBbox() {
	            return bbox;
	        }

	        public Integer getTravelDuration() {
	            return travelDuration;
	        }

	        public String getTrafficCongestion() {
	            return trafficCongestion;
	        }

	        public Double getTravelDistance() {
	            return travelDistance;
	        }

	        public String getId() {
	            return id;
	        }

	        public String getDurationUnit() {
	            return durationUnit;
	        }

	        public Integer getTravelDurationTraffic() {
	            return travelDurationTraffic;
	        }

	        public String getTravelMode() {
	            return travelMode;
	        }
	 }
