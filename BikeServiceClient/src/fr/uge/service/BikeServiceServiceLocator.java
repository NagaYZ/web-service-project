/**
 * BikeServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.service;

public class BikeServiceServiceLocator extends org.apache.axis.client.Service implements fr.uge.service.BikeServiceService {

    public BikeServiceServiceLocator() {
    }


    public BikeServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BikeServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BikeService
    private java.lang.String BikeService_address = "http://localhost:8080/GustaveBikeService/services/BikeService";

    public java.lang.String getBikeServiceAddress() {
        return BikeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BikeServiceWSDDServiceName = "BikeService";

    public java.lang.String getBikeServiceWSDDServiceName() {
        return BikeServiceWSDDServiceName;
    }

    public void setBikeServiceWSDDServiceName(java.lang.String name) {
        BikeServiceWSDDServiceName = name;
    }

    public fr.uge.service.BikeService getBikeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BikeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBikeService(endpoint);
    }

    public fr.uge.service.BikeService getBikeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uge.service.BikeServiceSoapBindingStub _stub = new fr.uge.service.BikeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBikeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBikeServiceEndpointAddress(java.lang.String address) {
        BikeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uge.service.BikeService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uge.service.BikeServiceSoapBindingStub _stub = new fr.uge.service.BikeServiceSoapBindingStub(new java.net.URL(BikeService_address), this);
                _stub.setPortName(getBikeServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BikeService".equals(inputPortName)) {
            return getBikeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.uge.fr", "BikeServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.uge.fr", "BikeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BikeService".equals(portName)) {
            setBikeServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
