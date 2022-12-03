/**
 * BikeServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.service;

public interface BikeServiceService extends javax.xml.rpc.Service {
    public java.lang.String getBikeServiceAddress();

    public fr.uge.service.BikeService getBikeService() throws javax.xml.rpc.ServiceException;

    public fr.uge.service.BikeService getBikeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
