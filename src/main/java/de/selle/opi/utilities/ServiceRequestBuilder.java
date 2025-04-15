package de.selle.opi.utilities;

import de.selle.opi.jaxb.ServiceRequest;

public class ServiceRequestBuilder {
	private final ServiceRequestType serviceRequestType;
	private int requestID;
	private String workstationId;

	public ServiceRequestBuilder(final ServiceRequestType serviceRequestType) {
		this.serviceRequestType = serviceRequestType;
	}

	/**
	 * @return the workstationId
	 */
	public final String getWorkstationId() {
		return workstationId;
	}

	/**
	 * Identifies the logical workstation (associated to the socket) sending the
	 * request: it can be only one at a time, sending only one request at a time.
	 * Usually the POS (more than one POS might be present); also an OPT identifies
	 * a logical workstation; in case of CRIND (usually two sides, one per filling
	 * position of the pump) it counts as two logical workstations. NOTE: Not
	 * renamed to avoid recoding in the interface implementation already in place.
	 * 
	 * @param workstationId the workstationId to set
	 * @return {@link ServiceRequestBuilder}
	 */
	public final ServiceRequestBuilder setWorkstationId(String workstationId) {
		this.workstationId = workstationId;
		return this;
	}

	/**
	 * @return the serviceRequestType
	 */
	public final ServiceRequestType getServiceRequestType() {
		return serviceRequestType;
	}

	/**
	 * @return the requestID
	 */
	public final int getRequestID() {
		return requestID;
	}

	/**
	 * @param requestID the requestID to set
	 *  @return {@link ServiceRequestBuilder}
	 */
	public final ServiceRequestBuilder setRequestID(int requestID) {
		this.requestID = requestID;
		return this;
	}

	public ServiceRequestInternal build() {
		return new ServiceRequestInternal(this);
	}
}
